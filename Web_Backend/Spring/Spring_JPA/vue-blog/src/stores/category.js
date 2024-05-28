import { ref } from "vue";
import { defineStore } from "pinia";

import { listBoardMenus } from "@/api/admin/make-board";

export const useCategoryStore = defineStore("category", () => {
  const menuItems = ref([]);

  const getCategories = () => {
    listBoardMenus(
      ({ data }) => {
        menuItems.value = data;
      },
      (error) => {
        console.error(error);
      }
    );
  };

  return { menuItems, getCategories };
});
