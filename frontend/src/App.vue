<template>
  <div id="app">
    <el-container class="my-container">
      <el-aside>
        <el-menu default-active="1">
          <el-menu-item index="1" @click="redirectUrl('singleFileUpload')">
            <i class="el-icon-menu"></i>
            <span slot="title">单文件上传</span>
          </el-menu-item>
          <el-menu-item index="2" @click="redirectUrl('multiFileUpload')">
            <i class="el-icon-upload"></i>
            <span slot="title">多文件上传</span>
          </el-menu-item>
          <el-menu-item index="3" @click="redirectUrl('bigFileUpload')">
            <i class="el-icon-tickets"></i>
            <span slot="title">大文件上传</span>
          </el-menu-item>
          <el-menu-item index="4" @click="redirectUrl('stopUpload')">
            <i class="el-icon-document"></i>
            <span slot="title">断点续传</span>
          </el-menu-item>
          <el-menu-item index="5" @click="redirectUrl('quickUpload')">
            <i class="el-icon-upload"></i>
            <span slot="title">秒传</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header class="my-header">
        </el-header>
        <el-main class="my-main">
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
    }
  },
  methods: {
    redirectUrl(val){
      this.$router.push('/'+val)
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
  .my-container {
    margin: 0 auto;
    position: absolute;
    width: 100%;
    height: 100%;
  }
  .my-header {
    background-color: deepskyblue;
    height: 20px;
  }
  .my-main {
    margin: 1em 1em;
  }
</style>
