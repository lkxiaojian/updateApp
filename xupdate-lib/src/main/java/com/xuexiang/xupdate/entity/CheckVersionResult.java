/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xupdate.entity;

/**
 * 版本更新检查返回的结果
 * <p>
 * 0:无版本更新
 * 1:有版本更新，不需要强制升级
 * 2:有版本更新，需要强制升级
 *
 * @author
 * @since 2018/7/5 下午5:34
 */
public class CheckVersionResult {
    private int code;
    private String msg;
    private Data data;

    /**
     * 无版本更新
     */
    public final static int NO_NEW_VERSION = 0; // 0:无版本更新
    /**
     * 有版本更新，不需要强制升级
     */
    public final static int HAVE_NEW_VERSION = 1; // 1:有版本更新，不需要强制升级
    /**
     * 有版本更新，需要强制升级
     */
    public final static int HAVE_NEW_VERSION_FORCED_UPLOAD = 2; // 2:有版本更新，需要强制升级
    public static String pjurl = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {


        private String name;
        private int version;
        private boolean updateForce;
        private String updateInfo;
        private long size;
        private String url;
        private String qrCodeUrl;
        private String createDate;
        /**
         * Apk MD5值
         */
        private String ApkMd5;

        private int UpdateStatus;

        public int getUpdateStatus() {
            return UpdateStatus;
        }

        public void setUpdateStatus(int updateStatus) {
            UpdateStatus = updateStatus;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public boolean isUpdateForce() {
            return updateForce;
        }

        public void setUpdateForce(boolean updateForce) {
            this.updateForce = updateForce;
        }

        public String getUpdateInfo() {
            return updateInfo;
        }

        public void setUpdateInfo(String updateInfo) {
            this.updateInfo = updateInfo;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getUrl() {
            return pjurl + url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getQrCodeUrl() {
            return qrCodeUrl;
        }

        public void setQrCodeUrl(String qrCodeUrl) {
            this.qrCodeUrl = qrCodeUrl;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }


        public String getApkMd5() {
            return ApkMd5;
        }

        public void setApkMd5(String apkMd5) {
            ApkMd5 = apkMd5;
        }
    }


//    /**
//     * 无版本更新
//     */
//    public final static int NO_NEW_VERSION = 0; // 0:无版本更新
//    /**
//     * 有版本更新，不需要强制升级
//     */
//    public final static int HAVE_NEW_VERSION = 1; // 1:有版本更新，不需要强制升级
//    /**
//     * 有版本更新，需要强制升级
//     */
//    public final static int HAVE_NEW_VERSION_FORCED_UPLOAD = 2; // 2:有版本更新，需要强制升级
//    /**
//     * 请求返回码
//     */
//    private int Code;
//    /**
//     * 请求信息
//     */
//    private String Msg;
//
//    /**
//     * 更新的状态
//     */
//    private int UpdateStatus;
//    /**
//     * 最新版本号[根据版本号来判别是否需要升级]
//     */
//    private int VersionCode;
//    /**
//     * 最新APP版本的名称[用于展示的版本名]
//     */
//    private String VersionName;
//    /**
//     * APP更新时间
//     */
//    private String UploadTime;
//    /**
//     * APP变更的内容
//     */
//    private String ModifyContent;
//    /**
//     * 下载地址
//     */
//    private String DownloadUrl;
//    /**
//     * Apk MD5值
//     */
//    private String ApkMd5;
//    /**
//     * Apk大小【单位：KB】
//     */
//    private long ApkSize;
//
//    public int getCode() {
//        return Code;
//    }
//
//    public CheckVersionResult setCode(int code) {
//        Code = code;
//        return this;
//    }
//
//    public String getMsg() {
//        return Msg;
//    }
//
//    public CheckVersionResult setMsg(String msg) {
//        Msg = msg;
//        return this;
//    }
//
//    public int getUpdateStatus() {
//        return UpdateStatus;
//    }
//
//    public CheckVersionResult setRequireUpgrade(int updateStatus) {
//        UpdateStatus = updateStatus;
//        return this;
//    }
//
//    public String getUploadTime() {
//        return UploadTime;
//    }
//
//    public CheckVersionResult setUploadTime(String uploadTime) {
//        UploadTime = uploadTime;
//        return this;
//    }
//
//    public int getVersionCode() {
//        return VersionCode;
//    }
//
//    public CheckVersionResult setVersionCode(int versionCode) {
//        VersionCode = versionCode;
//        return this;
//    }
//
//    public String getVersionName() {
//        return VersionName;
//    }
//
//    public CheckVersionResult setVersionName(String versionName) {
//        VersionName = versionName;
//        return this;
//    }
//
//    public String getModifyContent() {
//        return ModifyContent;
//    }
//
//    public CheckVersionResult setModifyContent(String modifyContent) {
//        ModifyContent = modifyContent;
//        return this;
//    }
//
//    public String getDownloadUrl() {
//        return DownloadUrl;
//    }
//
//    public CheckVersionResult setDownloadUrl(String downloadUrl) {
//        DownloadUrl = downloadUrl;
//        return this;
//    }
//
//    public String getApkMd5() {
//        return ApkMd5;
//    }
//
//    public CheckVersionResult setApkMd5(String apkMd5) {
//        ApkMd5 = apkMd5;
//        return this;
//    }
//
//    public long getApkSize() {
//        return ApkSize;
//    }
//
//    public CheckVersionResult setApkSize(long apkSize) {
//        ApkSize = apkSize;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "CheckVersionResult{" +
//                "Code=" + Code +
//                ", Msg='" + Msg + '\'' +
//                ", UpdateStatus=" + UpdateStatus +
//                ", VersionCode=" + VersionCode +
//                ", VersionName='" + VersionName + '\'' +
//                ", UploadTime='" + UploadTime + '\'' +
//                ", ModifyContent='" + ModifyContent + '\'' +
//                ", DownloadUrl='" + DownloadUrl + '\'' +
//                ", ApkMd5='" + ApkMd5 + '\'' +
//                ", ApkSize=" + ApkSize +
//                '}';
//    }
}
