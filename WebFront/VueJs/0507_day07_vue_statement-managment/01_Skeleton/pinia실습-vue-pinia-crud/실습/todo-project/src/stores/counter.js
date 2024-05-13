import { ref, computed } from "vue";
import { defineStore } from "pinia";

//store
export const useCounterStore = defineStore("counter", () => {
  //저장소 -> 여기다가 모든 state, getters, actions를 정의하면 된다.
  //id는 계속 올라감 -> 순서
  let id = 0;
  //내가 할일 들
  const todos = ref([
    { id: ++id, text: "꼬부기", isDone: false },
    { id: ++id, text: "밥먹기", isDone: false },
    { id: ++id, text: "집가기", isDone: false },
    { id: ++id, text: "잠자기", isDone: false },
  ]);
  //getters
  const doneTodosCount = computed(() => {
    return todos.value.filter((todo) => todo.isDone).length;
  });
  //action
  const createTodo = function (todoText) {
    todos.value.push({
      id: todos.value.length + 1,
      text: todoText,
      isDone: false,
    });
  };
  const deleteTodo = function (todoId) {
    const idx = todos.value.findIndex((todo) => todo.id === todoId);
    todos.value.splice(idx, 1);
  };
  const updateTodo = function (todoId) {
    todos.value = todos.value.map((todo) => {
      if (todo.id === todoId) {
        todo.isDone = !todo.isDone;
      }
      return todo;
    });
  };
  return {
    todos,
    createTodo,
    deleteTodo,
    updateTodo,
    doneTodosCount,
  };
});
