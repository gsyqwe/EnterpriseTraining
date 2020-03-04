<template>
  <div id="app">
    <Head />
    <router-view></router-view>
  </div>
</template>

<script>
import Head from './components/Head'
export default {
  components: {
      Head
  }
}
</script>

<style>

</style>
