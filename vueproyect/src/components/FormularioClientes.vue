<template>
    <div class="container">
        <h1> Formulario de Clientes</h1>
        <form id="client-form" @submit.prevent="guardar">
          <div class="form-group">
             <label for="idCliente">IdCliente:</label>
             <input type="number" id="idCliente" name="idCliente" required v-model="idCliente" />
             </div>
          <div class="form-group">
             <label for="nombre">Nombre:</label>
             <input type="text" id="nombre" name="nombre" required v-model="nombre" />
             </div> 
          <div class="form-group">
             <label for="apellido">Apellido:</label>
             <input type="text" id="apellido" name="apellido" required v-model="apellido" />
             </div>  
          <div class="form-group">
             <label for="identificacion">Identificación:</label>
             <input type="number" id="identificacion" name="identificacion" required v-model="identificacion" />
             </div>
          <div class="form-group">
             <label for="edad">Edad:</label>
             <input type="number" id="edad" name="edad" required v-model="edad" />
             </div> 
          <div class="form-group">
             <label for="telefono">Teléfono:</label>
             <input type="number" id="telefono" name="telefono" required v-model="telefono" />
             </div> 
          <div class="form-group">
             <label for="email">Email:</label>
             <input type="text" id="email" name="email" required v-model="email" />
             </div> 
            
          <button type="submit" id="guardar" name="guardar">Guardar</button><br />
          <button type="button" id="eliminar" name="eliminar" @click="eliminar"> Eliminar </button><br />
          <button type="button" id="actualizar" name="actualizar" @click="actualizar"> Actualizar </button><br />
          <button type="button" id="consultar" name="consultar" @click="consultar"> Consultar </button><br />
        </form>
    </div>
</template>

<script>

import axios from 'axios';

export default {

   data() {

      return {
         idCliente: null,
         nombre: "",
         apellido: "",
         identificacion: null,
         edad: null,
         telefono: null,
         email: ""
      };
   },
   methods: {

      guardar() {

         axios
            .post('http://localhost:8080/api/clientes', {
               idCliente: this.idCliente,
               nombre: this.nombre,
               apellido: this.apellido,
               identificacion: this.identificacion,
               edad: this.edad,
               telefono: this.telefono,
               email: this.email
            })
            .then((response) => {
               console.log("Cliente registrado con éxito:", response.data);
               alert("éxito");
               this.idCliente="";
            this.nombre="";
            this.apellido="";
            this.identificacion="";
            this.edad="";
            this.telefono="";
            this.email="";
            })
            .catch((error) => {
               console.error("Error al registrar cliente:", error);
               });
            
            },

            consultar() {

               axios
                  .get('http://localhost:8080/api/clientes/'+this.idCliente)
                  .then ((response) => {
                     //Actualizar los campos del formulario con los datos del cliente consultado
                     this.nombre = response.data.nombre;
                     this.apellido = response.data.apellido;
                     this.identificacion = response.data.identificacion;
                     this.edad = response.data.edad;
                     this.telefono = response.data.telefono;
                     this.email = response.data.email;
                  })
                  .catch((error) => {
                     console.error ("Error al consultar cliente:", error);
                     });
            },

            actualizar() {

               axios
                  .put("http://localhost:8080/api/clientes/actualizar/"+this.idCliente, {
                     idCliente:this.idCliente,
                     nombre: this.nombre,
                     apellido: this.apellido,
                     identificacion: this.identificacion,
                     edad: this.edad,
                     telefono: this.telefono,
                     email: this.email,
                  })
                  .then((response) => {
                     console.log("Cliente actualizado con éxito:", response.data);
                  })
                  .catch((error) => {
                     console.error("Error al actualizar cliente:", error);
                  });                   

           },
           eliminar(){

            axios
               .delete("http://localhost:8080/api/clientes/"+this.idCliente)
               .then(()  =>  {
                  console.log("Estudiante eliminado con éxito");
                  //Limpiar los campos del formulario después de eliminar
                  this.idCliente=null;
                  this.nombre="";
                  this.apellido="";
                  this.identificacion=null;
                  this.edad=null;
                  this.telefono=null;
                  this.email="";
               })
               .catch((error) =>{

                  console.error("Error al eliminar cliente:", error);
               });
           },

   },

};

</script>