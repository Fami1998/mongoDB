<template>
  <div>
    <h2>Register</h2>
    <form @submit.prevent="register">
      <input v-model="username" placeholder="Username" />
      <input type="password" v-model="password" placeholder="Password" />
      <input type="password" v-model="confirmPassword" placeholder="Confirm Password" />
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "shopping-register",
  data() {
    return {
      username: "",
      password: "",
      confirmPassword: "",
    };
  },
  methods: {
    register() {
      // Registration logic
      if (this.password !== this.confirmPassword) {
        alert("Passwords do not match!");
        return;
      }
      const user = {
        username: this.username,
        password: this.password,
      };
      fetch("http://localhost:8080/api/users/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      })
          .then((response) => response.json())
          .then((data) => {
            // Handle registration success
            console.log("Registration successful", data);
          })
          .catch((error) => {
            // Handle registration failure
            console.error("Registration failed", error);
          });
    },
  },
};
</script>

<style scoped>
/* 样式 */
</style>
