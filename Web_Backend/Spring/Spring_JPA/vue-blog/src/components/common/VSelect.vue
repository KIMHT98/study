<script setup>
import { ref } from "vue";
defineProps({ selectOption: Array });
const emit = defineEmits(["onKeySelect"]);

const key = ref("");

const onSelect = () => {
  console.log(key.value + "선택!!!");
  emit("onKeySelect", key.value);
};
</script>

<template>
  <select
    class="peer h-full w-full rounded-[7px] border text-pink-600 border-pink-600 border-t-transparent bg-transparent px-3 py-2.5 font-sans text-sm font-normal outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-pink-600 focus:border-2 focus:border-pink-600 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-pink-50"
    v-model="key"
    @change="onSelect"
  >
    <option
      v-for="option in selectOption"
      :key="option.value"
      :value="option.value"
      :disabled="option.value === '' ? true : false"
    >
      {{ option.text }}
    </option>
  </select>
  <label
    class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-pink-600 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-pink-600 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-pink-600 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-pink-600 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-600 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-pink-600 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-pink-600 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-pink-600"
  >
    검색조건
  </label>
</template>

<style scoped></style>
