<template>
  <div>
    <uploader
        ref="uploader"
        browse_button="browse_button"
        start_button="start_button"
        v-model="files"
        url="http://localhost:8080/BigFileUpload/"
        chunk_size="2MB"
        :FilesAdded="filesAdded"
        :BeforeUpload="beforeUpload"
        @queueProgress="queueProgress"
    />
    <el-button id="browse_button" type="primary">选择文件</el-button>
    <span v-for="file in files">
      {{file.name}}
    </span>
    <el-button id="start_button" type="info">上传</el-button>
    <hr/>
    <span>{{total}}</span>
  </div>
</template>

<script>
  import FileMd5 from '../models/file-md5.js'
  import Uploader from './Uploader'
  export default {
    name: 'BigFileUpload',
    data() {
      return {
        files:[],
        total:{}
      }
    },
    components: {
      'uploader': Uploader
    },
    methods: {
      filesAdded(up, files) {
        files.forEach((f) => {
          FileMd5(f.getNative(), (e, md5) => {
            f["md5"] = md5;
            console.log(f);
          });
        });
      },
      beforeUpload(up, file) {
        up.setOption("multipart_params", {"md5":file.md5});
      },
      queueProgress(total) {
        this.total = total;
      }
    }
  }
</script>

<style scoped>

</style>

