const API_URL = "http://localhost:35000/api/properties";

// Cargar propiedades al iniciar
document.addEventListener("DOMContentLoaded", loadProperties);

// Función para cargar propiedades
async function loadProperties() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar las propiedades");
        const properties = await response.json();
        const tbody = document.querySelector("#propertyTable tbody");
        tbody.innerHTML = properties.length === 0
            ? `<tr><td colspan="7" class="empty-message">No hay propiedades registradas.</td></tr>`
            : properties.map(property => `
                <tr>
                    <td>${property.id}</td>
                    <td>${property.address}</td>
                    <td>${property.price}</td>
                    <td>${property.size}</td>
                    <td>${property.description}</td>
                    <td>${property.phone}</td>
                    <td>
                        <button class="edit" onclick="editProperty(${property.id})">Editar</button>
                        <button class="delete" onclick="deleteProperty(${property.id})">Eliminar</button>
                    </td>
                </tr>
            `).join("");
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un error al cargar las propiedades.");
    }
}

// Función para crear o actualizar una propiedad
document.getElementById("propertyForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const property = {
        id: document.getElementById("propertyId").value || null,
        address: document.getElementById("address").value,
        price: parseFloat(document.getElementById("price").value),
        size: parseFloat(document.getElementById("size").value),
        description: document.getElementById("description").value,
        phone: document.getElementById("phone").value
    };

    const method = property.id ? "PUT" : "POST";
    const url = property.id ? `${API_URL}/${property.id}` : API_URL;

    try {
        const response = await fetch(url, {
            method: method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(property)
        });

        if (!response.ok) throw new Error("Error al guardar la propiedad");

        alert(property.id ? "Propiedad actualizada exitosamente." : "Propiedad creada exitosamente.");
        document.getElementById("propertyForm").reset();
        loadProperties(); // Recargar la lista de propiedades
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un error al guardar la propiedad.");
    }
});

// Función para editar una propiedad
async function editProperty(id) {
    try {
        const response = await fetch(`${API_URL}/${id}`);
        if (!response.ok) throw new Error("Error al cargar la propiedad");
        const property = await response.json();
        document.getElementById("propertyId").value = property.id;
        document.getElementById("address").value = property.address;
        document.getElementById("price").value = property.price;
        document.getElementById("size").value = property.size;
        document.getElementById("description").value = property.description;
        document.getElementById("phone").value = property.phone;
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un error al cargar la propiedad.");
    }
}

// Función para eliminar una propiedad
async function deleteProperty(id) {
    if (confirm("¿Estás seguro de que deseas eliminar esta propiedad?")) {
        try {
            const response = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
            if (!response.ok) throw new Error("Error al eliminar la propiedad");
            loadProperties(); // Recargar la lista de propiedades
            alert("Propiedad eliminada exitosamente.");
        } catch (error) {
            console.error("Error:", error);
            alert("Hubo un error al eliminar la propiedad.");
        }
    }
}