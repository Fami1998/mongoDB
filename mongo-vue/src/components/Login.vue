<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <input v-model="username" placeholder="Username" />
      <input type="password" v-model="password" placeholder="Password" />
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "shopping-login",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    login() {
      // Login logic
      const user = {
        username: this.username,
        password: this.password,
      };
      fetch("http://localhost:8080/api/users/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      })
          .then((response) => response.json())
          .then((data) => {
            // Handle login success
            console.log("Login successful", data);
          })
          .catch((error) => {
            // Handle login failure
            console.error("Login failed", error);
          });
    },
  },
};
</script>

<style scoped>
/* 样式 */
</style>
