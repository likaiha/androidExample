package com.hzbk.aichat.entity;

import java.util.List;

public class HomePageNoticeBean {

    private String code;
    private String msg;
    private DataDTO data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private List<ListDTO> list;

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public static class ListDTO {
            private String id;
            private String parent_id;
            private String post_type;
            private String post_format;
            private String user_id;
            private String post_status;
            private String comment_status;
            private String is_top;
            private String recommended;
            private String post_hits;
            private String post_favorites;
            private String post_like;
            private String comment_count;
            private String create_time;
            private String update_time;
            private String published_time;
            private String delete_time;
            private String post_title;
            private String post_keywords;
            private String post_excerpt;
            private String post_source;
            private String thumbnail;
            private String post_content;
            private Object post_content_filtered;
            private MoreDTO more;
            private Integer post_category_id;
            private String list_order;
            private String category_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getPost_type() {
                return post_type;
            }

            public void setPost_type(String post_type) {
                this.post_type = post_type;
            }

            public String getPost_format() {
                return post_format;
            }

            public void setPost_format(String post_format) {
                this.post_format = post_format;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getPost_status() {
                return post_status;
            }

            public void setPost_status(String post_status) {
                this.post_status = post_status;
            }

            public String getComment_status() {
                return comment_status;
            }

            public void setComment_status(String comment_status) {
                this.comment_status = comment_status;
            }

            public String getIs_top() {
                return is_top;
            }

            public void setIs_top(String is_top) {
                this.is_top = is_top;
            }

            public String getRecommended() {
                return recommended;
            }

            public void setRecommended(String recommended) {
                this.recommended = recommended;
            }

            public String getPost_hits() {
                return post_hits;
            }

            public void setPost_hits(String post_hits) {
                this.post_hits = post_hits;
            }

            public String getPost_favorites() {
                return post_favorites;
            }

            public void setPost_favorites(String post_favorites) {
                this.post_favorites = post_favorites;
            }

            public String getPost_like() {
                return post_like;
            }

            public void setPost_like(String post_like) {
                this.post_like = post_like;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getPublished_time() {
                return published_time;
            }

            public void setPublished_time(String published_time) {
                this.published_time = published_time;
            }

            public String getDelete_time() {
                return delete_time;
            }

            public void setDelete_time(String delete_time) {
                this.delete_time = delete_time;
            }

            public String getPost_title() {
                return post_title;
            }

            public void setPost_title(String post_title) {
                this.post_title = post_title;
            }

            public String getPost_keywords() {
                return post_keywords;
            }

            public void setPost_keywords(String post_keywords) {
                this.post_keywords = post_keywords;
            }

            public String getPost_excerpt() {
                return post_excerpt;
            }

            public void setPost_excerpt(String post_excerpt) {
                this.post_excerpt = post_excerpt;
            }

            public String getPost_source() {
                return post_source;
            }

            public void setPost_source(String post_source) {
                this.post_source = post_source;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getPost_content() {
                return post_content;
            }

            public void setPost_content(String post_content) {
                this.post_content = post_content;
            }

            public Object getPost_content_filtered() {
                return post_content_filtered;
            }

            public void setPost_content_filtered(Object post_content_filtered) {
                this.post_content_filtered = post_content_filtered;
            }

            public MoreDTO getMore() {
                return more;
            }

            public void setMore(MoreDTO more) {
                this.more = more;
            }

            public Integer getPost_category_id() {
                return post_category_id;
            }

            public void setPost_category_id(Integer post_category_id) {
                this.post_category_id = post_category_id;
            }

            public String getList_order() {
                return list_order;
            }

            public void setList_order(String list_order) {
                this.list_order = list_order;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public static class MoreDTO {
                private String audio;
                private String video;
                private String thumbnail;
                private String template;
                private List<PhotosDTO> photos;

                public String getAudio() {
                    return audio;
                }

                public void setAudio(String audio) {
                    this.audio = audio;
                }

                public String getVideo() {
                    return video;
                }

                public void setVideo(String video) {
                    this.video = video;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public String getTemplate() {
                    return template;
                }

                public void setTemplate(String template) {
                    this.template = template;
                }

                public List<PhotosDTO> getPhotos() {
                    return photos;
                }

                public void setPhotos(List<PhotosDTO> photos) {
                    this.photos = photos;
                }

                public static class PhotosDTO {
                    private String url;
                    private String name;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }
        }
    }
}
