<template>
  <div>
    <header>
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <span> | </span>
        <RouterLink to="/youtube">Youtube</RouterLink>
      </nav>
    </header>
    <router-view />
  </div>
</template>

<script setup></script>

<style scoped></style>
