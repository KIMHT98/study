<script setup>
import { computed } from "vue";

const props = defineProps({ currentPage: Number, totalPage: Number });
const emit = defineEmits(["pageChange"]);

const navigationSize = parseInt(import.meta.env.VITE_NAVIGATION_SIZE);

const startPage = computed(() => {
  return parseInt((props.currentPage - 1) / navigationSize) * navigationSize + 1;
});

const endPage = computed(() => {
  let lastPage =
    parseInt((props.currentPage - 1) / navigationSize) * navigationSize + navigationSize;
  return props.totalPage < lastPage ? props.totalPage : lastPage;
});

const endRange = computed(() => {
  return parseInt((props.totalPage - 1) / navigationSize) * navigationSize < props.currentPage;
});

function range(start, end) {
  const list = [];
  for (let i = start; i <= end; i++) list.push(i);
  return list;
  //   return Array(end - start + 1)
  //     .fill()
  //     .map((val, i) => start + i);
}

function onPageChange(pg) {
  emit("pageChange", pg);
}
</script>

<template>
  <nav>
    <ul class="flex">
      <li>
        <a
          class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
          @click="onPageChange(1)"
          aria-label="Previous"
        >
          <span class="material-icons-outlined"> first_page </span>
        </a>
      </li>
      <li>
        <a
          class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
          @click="onPageChange(startPage == 1 ? 1 : startPage - 1)"
          aria-label="Previous"
        >
          <span class="material-icons text-sm">keyboard_arrow_left</span>
        </a>
      </li>
      <template v-for="pg in range(startPage, endPage)" :key="pg">
        <li>
          <a
            class="mx-1 flex h-9 w-9 items-center justify-center rounded-full p-0 text-sm transition duration-150 ease-in-out"
            :class="
              currentPage === pg
                ? ' bg-pink-500 text-white shadow-m'
                : 'border border-blue-gray-100 bg-transparent text-blue-gray-500 hover:bg-light-300'
            "
            @click="onPageChange(pg)"
          >
            {{ pg }}
          </a>
        </li>
      </template>
      <li>
        <a
          class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
          @click="onPageChange(endRange ? totalPage : endPage + 1)"
          aria-label="Next"
        >
          <span class="material-icons text-sm">keyboard_arrow_right</span>
        </a>
      </li>
      <li>
        <a
          class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
          @click="onPageChange(totalPage)"
          aria-label="Next"
        >
          <span class="material-icons-outlined"> last_page </span>
        </a>
      </li>
    </ul>
  </nav>
</template>

<style scoped></style>
