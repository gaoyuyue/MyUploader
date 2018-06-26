<template>
    <div>
      <uploader
        browse_button="browse_button"
        start_button="start_button"
        :url="server_config.url+'/File/'"
        :multi_selection="false"
        v-model="files"
        :FilesAdded="filesAdded"
      />
      <el-button id="browse_button" type="primary">选择文件</el-button>
      <span v-for="file in files">{{file.name}}</span>
      <el-button id="start_button" type="danger ">开始上传</el-button>
    </div>
</template>

<script>
  import Uploader from './Uploader'
  export default {
    name: "SingleFileUpload",
    data() {
      return {
        server_config: this.global.server_config,
        files:[]
      }
    },
    methods: {
      /**
       * setting single file limit
       * @param up
       * @param files
       */
      filesAdded(up, files) {
        if (up.files.length > 1) {
          up.removeFile(up.files[0])
        }
      }
    },
    components: {
      'uploader': Uploader
    },
  }
</script>

<style scoped>

</style>
