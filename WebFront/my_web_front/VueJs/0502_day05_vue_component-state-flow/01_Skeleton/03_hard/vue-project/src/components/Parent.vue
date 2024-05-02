<template>
  <div>
    <!-- ParentChild: <ParentChild my-msg="하이" /> -->
    <!-- <ParentChild my-msg="message" :dynamic-props="name" /> -->
    <!-- ParentChild: <ParentChild @some-event="someCallback" /> -->
    <!-- ParentChild :  -->
    <ParentChild
      @some-event="someCallback"
      @emit-args="getNumbers"
      my-msg="하이"
    />
  </div>
</template>

<script setup>
import { ref } from "vue";
import ParentChild from "@/components/ParentChild.vue";
const name = ref("Terry");
const someCallback = function () {
  console.log("allfine");
};
const getNumbers = function (...arg) {
  console.log(arg);
  console.log(`숫자 : ${arg}입니다.`);
};
</script>

<style scoped></style>
