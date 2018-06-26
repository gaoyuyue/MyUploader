<script>
  import plupload from 'plupload/js/plupload.full.min.js'
  export default {
    name: "Uploader",
    props: {
      value: {
        type: Array
      },
      browse_button: {
        type: String
      },
      start_button: {
        type: String
      },
      stop_button: {
        type: String
      },
      container: {
        type: String
      },
      url: {
        type: String
      },
      filters: {
        type: Object
      },
      headers: {
        type: Object
      },
      multipart_params: {
        type: Object
      },
      resize: {
        type: Object
      },
      drop_element: {
        type: String
      },
      required_features: {
        type: String
      },
      runtimes: {
        type: String,
        default() {
          return "html5,flash,silverlight,html4";
        }
      },
      chunk_size: {
        type: String,
        default() {
          return "0";
        }
      },
      multipart: {
        type: Boolean,
        default(){
          return true;
        }
      },
      max_retries: {
        type: Number,
        default() {
          return 0;
        }
      },
      multi_selection: {
        type: Boolean,
        default() {
          return true;
        }
      },
      unique_names: {
        type: Boolean,
        default() {
          return false;
        }
      },
      file_data_name: {
        type: String,
        default() {
          return "file";
        }
      },
      flash_swf_url: {
        type: String,
        default() {
          return 'plupload/js/Moxie.swf';
        }
      },
      silverlight_xap_url: {
        type: String,
        default() {
          return "plupload/js/Moxie.xap";
        }
      },
      Init: {
        type: Function
      },
      PostInit: {
        type: Function
      },
      Browse: {
        type: Function
      },
      OptionChanged: {
        type: Function
      },
      Refresh: {
        type: Function
      },
      StateChanged: {
        type: Function
      },
      UploadFile: {
        type: Function
      },
      BeforeUpload: {
        type: Function
      },
      QueueChanged: {
        type: Function
      },
      UploadProgress: {
        type: Function
      },
      FilesRemoved: {
        type: Function
      },
      FileFiltered: {
        type: Function
      },
      FilesAdded: {
        type: Function
      },
      FileUploaded: {
        type: Function
      },
      ChunkUploaded: {
        type: Function
      },
      UploadComplete: {
        type: Function
      },
      Error: {
        type: Function
      },
      Destroy: {
        type: Function
      }
    },
    methods: {
      handle(up) {
        this.$emit('input', up.files);
        this.$emit('queueProgress', up.total);
      },
      init() {
        let that = this;
        const preInitMethod = {
          Init(up, info) {
            if (that.start_button != null) {
              document.getElementById(that.start_button).onclick = () => {
                up.start();
              };
            }
            if (that.stop_button != null) {
              document.getElementById(that.stop_button).onclick = () => {
                uploader.stop();
              }
            }
            if (that.Init != null) {
              that.Init(up, info);
            }
          },
          UploadFile(up, file) {
            if (that.UploadFile != null) {
              that.UploadFile(up, file);
            }
          }
        };
        const initMethod = {
          PostInit() {
            if (that.PostInit != null) {
              that.PostInit();
            }
          },
          Browse(up) {
            if (that.Browse != null) {
              that.Browse(up);
            }
          },
          OptionChanged(up, name, value, oldValue) {
            that.handle(up);
            if (that.OptionChanged != null) {
              that.OptionChanged(up, name, value, oldValue);
            }
          },
          Refresh(up) {
            that.handle(up);
            if (that.Refresh != null) {
              that.Refresh(up);
            }
          },
          StateChanged(up) {
            that.handle(up);
            if (that.StateChanged != null) {
              that.StateChanged(up);
            }
          },
          BeforeUpload(up, file) {
            if (that.BeforeUpload != null) {
              that.BeforeUpload(up, file);
            }
          },
          QueueChanged(up) {
            that.handle(up);
            if (that.QueueChanged != null) {
              that.QueueChanged(up);
            }
          },
          UploadProgress(up, file) {
            that.handle(up);
            if (that.UploadProgress != null) {
              that.UploadProgress(up, file);
            }
          },
          FilesRemoved(up, files) {
            that.handle(up);
            if (that.FilesRemoved != null) {
              that.FilesRemoved(up, files);
            }
          },
          FileFiltered(up, file) {
            if (that.FileFiltered != null) {
              that.FileFiltered(up, file);
            }
          },
          FilesAdded(up, files) {
            that.handle(up);
            if (that.FilesAdded != null) {
              that.FilesAdded(up, files);
            }
          },
          FileUploaded(up, file, info) {
            that.handle(up);
            if (that.FileUploaded != null) {
              that.FileUploaded(up, file, info);
            }
          },
          ChunkUploaded(up, file, info) {
            that.handle(up);
            if (that.ChunkUploaded != null) {
              that.ChunkUploaded(up, file, info);
            }
          },
          UploadComplete(up, files) {
            that.handle(up);
            if (that.UploadComplete != null) {
              that.UploadComplete(up, files);
            }
          },
          Error(up, args) {
            that.handle(up);
            if (that.Error != null) {
              that.Error(up, args);
            }
          },
          Destroy(up) {
            if (that.Destroy != null) {
              that.Destroy(up);
            }
          }
        };
        let prop = {
          runtimes: this.runtimes,
          browse_button: this.browse_button,
          container: this.container,
          url: this.url,
          chunk_size: this.chunk_size,
          headers: this.headers,
          multipart: this.multipart,
          max_retries: this.max_retries,
          multi_selection: this.multi_selection,
          unique_names: this.unique_names,
          file_data_name: this.file_data_name,
          flash_swf_url: this.flash_swf_url,
          silverlight_xap_url: this.silverlight_xap_url,
          preinit: preInitMethod,
          init: initMethod
        };
        if (this.filters != null) {
          prop["filters"] = this.filters;
        }
        if (this.multipart_params != null) {
          prop["multipart_params"] = this.multipart_params;
        }
        if (this.resize != null) {
          prop["resize"] = this.resize;
        }
        if (this.drop_element != null) {
          prop["drop_element"] = this.drop_element;
        }
        if (this.required_features != null) {
          prop["required_features"] = this.required_features;
        }
        new plupload.Uploader(prop).init();
      }
    },
    mounted() {
      this.init();
    }
  }
</script>
