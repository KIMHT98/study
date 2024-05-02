<template>
  <div>
    <ParentChild
      my-msg="message"
      @update-name="updateName"
      :dynamic-props="name"
    />
  </div>
</template>

<script setup>
import ParentChild from "@/components/ParentChild.vue";
import { ref } from "vue";
const name = ref("Terry");
const updateName = function () {
  if (name.value === "Terry") {
    name.value = "김현태";
  } else {
    name.value = "Terry";
  }
  console.log(name.value);
};
</script>
