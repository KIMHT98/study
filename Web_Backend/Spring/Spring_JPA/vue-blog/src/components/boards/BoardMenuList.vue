<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";

import { useCategoryStore } from "@/stores/category";
import { storeToRefs } from "pinia";

import IconMan from "@/components/icons/boards/IconMan.vue";
import IconWoman from "@/components/icons/boards/IconWoman.vue";
import IconBoardTypeText from "@/components/icons/boards/IconBoardTypeText.vue";
import IconBoardTypeReply from "@/components/icons/boards/IconBoardTypeReply.vue";
import IconBoardTypeImage from "@/components/icons/boards/IconBoardTypeImage.vue";
import IconBoardTypeFile from "@/components/icons/boards/IconBoardTypeFile.vue";

const router = useRouter();
const categoryStore = useCategoryStore();
const { getCategories } = categoryStore;
const { menuItems } = storeToRefs(categoryStore);

onMounted(() => {
  getCategories();
});

const listArticle = (board) => {
  let name = `${board.control}-list`;
  router.push({
    name: name,
    params: { bcode: board.bcode },
  });
};
</script>

<template>
  <!-- <div
    class="relative flex flex-col bg-clip-border rounded-xl bg-white text-gray-700 h-[calc(100vh-2rem)] w-full max-w-[20rem] p-4 shadow-xl shadow-gray-900/5"
  > -->
  <div
    class="relative flex flex-col bg-clip-border rounded-xl bg-white text-gray-700 w-full max-w-[20rem] p-4 shadow-xl shadow-gray-900/5"
  >
    <div class="mb-2 p-4">
      <h5
        class="block antialiased tracking-normal font-sans text-2xl text-center font-bold leading-snug text-gray-900"
      >
        SSAFY`s Blog
      </h5>
    </div>
    <nav
      class="flex flex-col gap-1 min-w-[240px] p-2 font-sans text-base font-normal text-gray-700"
    >
      <template v-for="category in menuItems" :key="category.ccode">
        <div
          role="button"
          tabindex="0"
          class="flex items-center w-full p-3 rounded-lg font-semibold text-start leading-tight transition-all bg-blue-100 hover:bg-blue-50 hover:bg-opacity-80 focus:bg-blue-50 focus:bg-opacity-80 active:bg-gray-50 active:bg-opacity-80 hover:text-blue-900 focus:text-blue-900 active:text-blue-900 outline-none"
        >
          <div class="grid place-items-center mr-2">
            <IconMan />
          </div>
          {{ category.cname }}
          <div class="grid place-items-center ml-2">
            <IconWoman />
          </div>
        </div>
        <template v-for="board in category.boardLists" :key="board.bcode">
          <div
            role="button"
            tabindex="0"
            class="flex items-center w-full p-1 pl-6 rounded-lg text-start leading-tight transition-all hover:bg-teal-100 hover:bg-opacity-80 focus:bg-teal-100 focus:bg-opacity-80 active:bg-teal-100 active:bg-opacity-80 hover:text-blue-900 focus:text-blue-900 active:text-blue-900 outline-none"
            @click="listArticle(board)"
          >
            <div class="grid place-items-center mr-2">
              <IconBoardTypeReply v-if="board.btype === 4" />
              <IconBoardTypeImage v-else-if="board.btype === 5" />
              <IconBoardTypeFile v-else-if="board.btype === 6" />
              <IconBoardTypeText v-else />
            </div>
            {{ board.bname }}
          </div>
        </template>
      </template>
    </nav>
  </div>
</template>

<style scoped></style>
