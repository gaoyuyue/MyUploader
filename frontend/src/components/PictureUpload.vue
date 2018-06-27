<template>
  <div>
    <uploader
      browse_button="browse_button"
      :url="server_config.url+'/File/'"
      :FilesAdded="filesAdded"
      @inputUploader="inputUploader"
    />
    <el-button id="browse_button" type="primary">选择图片</el-button>
    <br/>
    <br/>
    <el-row>
      <el-col :span="4" v-for="(image, index) in images" :key="index" :offset="index > 0 ? 1 : 0">
        <el-card :body-style="{ padding: '0px' }">
          <img width="240px" height="240px" :src="image.src" class="image">
          <div style="padding: 14px;">
              <el-button type="text" class="button" @click="deleteFile(index,image.id)">删除</el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <br/>
    <el-button type="danger" @click="up.start()">开始上传</el-button>
  </div>
</template>

<script>
  import Uploader from './Uploader'
  import FileUrl from '../models/file-url'

  export default {
    name: "PictureUpload",
    data() {
      return {
        server_config: this.global.server_config,
        files:[],
        up: {},
        images: [],
        changed: false
      }
    },
    components: {
      'uploader': Uploader
    },
    watch: {
      changed() {
        let images = [];
        this.files.forEach((e) => {
          images.push({src: e.imgsrc, id: e.id});
        });
        this.images = images;
      }
    },
    methods: {
      inputUploader(up) {
        this.up = up;
        this.files = up.files;
      },
      filesAdded(up, files) {
        files.forEach((f) => {
          FileUrl(f.getNative(), (err, imgsrc) => {
            f.imgsrc = imgsrc;
            this.changed = !this.changed;
          });
        });
      },
      deleteFile(index,id) {
        this.images.splice(index,1);
        let file = this.up.getFile(id);
        this.up.removeFile(file);
      }
    }
  }
</script>

<style scoped>

</style>
