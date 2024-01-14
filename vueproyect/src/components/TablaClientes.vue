<template>
    <div class="container">
        <h1>Tabla de Clientes</h1>
        <table>
            <thead>
                <tr>
                    <th>IdCliente</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Identificación</th>
                    <th>Edad</th>
                    <th>Teléfono</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>

                    <tr v-for="cliente in clientes" :key="cliente.idCliente">
                    <td>{{ cliente.idCliente}}</td>
                    <td>{{ cliente.nombre}}</td>
                    <td>{{ cliente.apellido}}</td>
                    <td>{{ cliente.identificacion}}</td>
                    <td>{{ cliente.edad}}</td>
                    <td>{{ cliente.telefono}}</td>
                    <td>{{ cliente.email}}</td>
                </tr>

                <router-view />

            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data () {
        return {
            clientes: [],
        };
    },
    methods: {
        obtenerClientes() {
            //Método para obtener la lista de todos los clientes
            axios.get("http://localhost:8080/api/clientes/listar")
            .then((response) => {
                this.clientes = response.data;
            })
            .catch((error) => {
                console.error("Error al obtener cliente:", error);
                });
        },
    },
    mounted() {
        //Llamar al método para obtener la lista de clientes al cargar el componente
        this.obtenerClientes();
    },
};

</script>