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
    <el-tag type="info">图片预览区域</el-tag>
    <el-row style="height: 360px; width: 100%; background-color: honeydew" >
      <el-col style="margin: 20px 20px" :span="4" v-for="(image, index) in images" :key="index" :offset="index > 0 ? 1 : 0">
        <el-card :body-style="{ padding: '0px' }">
          <img width="240px" height="240px" :src="image.src" class="image">
          <hr/>
          <div style="padding: 5px; display: flex">
              <div style="flex: 3; display: flex; justify-content:center;align-items:center;">
                <span v-if="image.file.status === 1" style="color: aqua;">准备上传</span>
                <span v-if="image.file.status === 4" style="color: brown">上传失败</span>
                <span v-if="image.file.status === 5" style="color: chartreuse">已上传</span>
                <el-progress v-if="image.file.status === 2" :text-inside="true" :stroke-width="20" :percentage="image.file.percent"></el-progress>
              </div>
              <el-button style="flex: 1" type="text" class="button" @click="deleteFile(index,image.file)">删除</el-button>
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
          images.push({src: e.imgsrc, file: e});
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
      deleteFile(index,file) {
        this.images.splice(index,1);
        this.up.removeFile(file);
      }
    }
  }
</script>

<style scoped>

</style>
