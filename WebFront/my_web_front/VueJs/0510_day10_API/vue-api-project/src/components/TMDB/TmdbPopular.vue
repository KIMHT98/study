<template>
  <div>
    <h1>인기순위</h1>
    <table>
      <tr>
        <th>순위</th>
        <th>포스터</th>
        <th>제목</th>
        <th>줄거리</th>
        <th>개봉일</th>
      </tr>
      <tr v-for="(movie, index) in movieList" :key="movie.id">
        <td>{{ index + 1 }}</td>
        <td>
          <img
            :src="`https://image.tmdb.org/t/p/w500/${movie['poster_path']}`"
            style="height: 100px"
          />
        </td>
        <td>{{ movie.title }}</td>
        <td>{{ movie.overview }}</td>
        <td>{{ movie["release_date"] }}</td>
      </tr>
    </table>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
const movieList = ref([]);
onMounted(() => {
  const api_key = import.meta.env.VITE_TMDB_API_KEY;
  const url = "https://api.themoviedb.org/3/movie/popular";
  const params = {
    api_key,
    language: "ko",
    region: "KR",
  };
  axios({
    url,
    method: "GET",
    params,
  })
    .then((response) => {
      // console.log(response.data);
      movieList.value = response.data.results;
    })
    .catch((error) => {
      console.error(error);
    });
});
</script>

<style scoped></style>
