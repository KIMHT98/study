<template>
  <div id="container">
    <header>
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <span> | </span>
        <RouterLink to="/youtube">Youtube</RouterLink>
        <span> | </span>
        <RouterLink :to="{ name: 'board-list' }">BoardList</RouterLink>
        <span> | </span>
        <RouterLink :to="{ name: 'board-create' }">BoardCreate</RouterLink>
      </nav>
    </header>
  </div>
</template>

<script setup></script>

<style scoped>
#container {
  text-align: center;
}
nav a {
  text-decoration: none;
  color: black;
}
nav {
  font-weight: bold;
  font-size: 30px;
}
.router-link-exact-active {
  color: green;
}
</style>
