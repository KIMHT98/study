<template>
  <div>
    <p>{{ myMsg }}</p>
    <p>{{ dynamicProps }}</p>
    <ParentGrandChild :my-msg="myMsg" @update-name="updateName" />
  </div>
</template>

<script setup>
import ParentGrandChild from "@/components/ParentGrandChild.vue";
const emit = defineEmits(["updateName"]);
const updateName = function () {
  emit("updateName");
};
defineProps({
  myMsg: String,
  dynamicProps: String,
});
</script>
