<template>
    <div>
      <uploader
        browse_button="browse_button"
        :url="server_config.url+'/File/'"
        :multi_selection="false"
        :FilesAdded="filesAdded"
        :filters="{
          mime_types : [
            { title : 'Image files', extensions : 'jpg,gif,png' },
            { title : 'Zip files', extensions : 'zip' }
          ],
          max_file_size : '400kb'
        }"
        @inputUploader="inputUploader"
      />
      <el-button id="browse_button" type="primary">选择文件</el-button>
      <span v-for="file in files">{{file.name}}</span>
      <el-button type="danger" @click="uploadStart()">开始上传</el-button>

      <el-dialog title="正在上传" :visible.sync="dialogTableVisible">
        <el-progress v-if="files.length>0" :text-inside="true" :stroke-width="20" :percentage="files[0].percent"></el-progress>
      </el-dialog>
      <br/>
      <br/>
      <el-tag type="warning">只允许上传图片和zip文件, 最大只能上传400kb的文件</el-tag>
    </div>
</template>

<script>
  import Uploader from './Uploader'
  export default {
    name: "SingleFileUpload",
    data() {
      return {
        server_config: this.global.server_config,
        files:[],
        up: {},
        dialogTableVisible: false
      }
    },
    computed: {
      status() {
        return this.files.length > 0 ? this.files[0].status : null;
      }
    },
    watch: {
      status() {
        if (this.status === 5) {
          this.$confirm('文件上传成功', '提示', {
            confirmButtonText: '确定',
            type: 'warning'
          }).then(() => {
            this.dialogTableVisible = false;
          });
        }
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
      },
      inputUploader(up) {
        this.up = up;
        this.files = up.files;
      },
      uploadStart() {
        this.dialogTableVisible = true;
        this.up.start();
      }
    },
    components: {
      'uploader': Uploader
    },
  }
</script>

<style scoped>

</style>
