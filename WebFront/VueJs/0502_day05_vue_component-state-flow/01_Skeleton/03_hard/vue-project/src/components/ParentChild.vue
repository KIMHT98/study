<template>
  <div>
    <!-- <p>{{ myMsg }}</p> -->
    <!-- <p>{{ dynamicProps }}</p> -->
    <!-- ParentGrandChild : <ParentGrandChild :my-msg="myMsg" /> -->

    <!-- <button @click="$emit('someEvent')">전달1</button> -->

    <!-- <button @click="buttonClick">전달2</button> -->
    <button @click="emitArgs">추가 인자 전달</button>
  </div>
</template>

<script setup>
import ParentGrandChild from "@/components/ParentGrandChild.vue";
//1.props를 받을 때 문자배열은 명시적이지 않다!
// defineProps(['myMsg'])

//2. 객체 권장
const props = defineProps({
  myMsg: String,
  dynamicProps: String,
});
console.log(props);
console.log(props.myMsg);
const emit = defineEmits(["someEvent", "emitArgs"]);

const buttonClick = function () {
  emit("someEvent");
};
const emitArgs = function () {
  emit("emitArgs", 1, 2, 3);
};
</script>
