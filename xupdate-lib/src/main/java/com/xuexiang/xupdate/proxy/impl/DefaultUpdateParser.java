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

package com.xuexiang.xupdate.proxy.impl;

import android.text.TextUtils;

import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.CheckVersionResult;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateParser;
import com.xuexiang.xupdate.utils.UpdateUtils;

/**
 * 版本更新解析器
 *
 * @author
 * @since 2018/7/5 下午4:36
 */
public class DefaultUpdateParser implements IUpdateParser {

    @Override
    public UpdateEntity parseJson(String json) {
        if (!TextUtils.isEmpty(json)) {
            CheckVersionResult checkResult = UpdateUtils.fromJson(json, CheckVersionResult.class);
            if (checkResult != null && checkResult.getCode() == 200) {
                checkResult = doLocalCompare(checkResult);

                UpdateEntity updateEntity = new UpdateEntity();
                if (checkResult.getData().getUpdateStatus() == CheckVersionResult.NO_NEW_VERSION) {
                    updateEntity.setHasUpdate(false);
                } else {
                    if (checkResult.getData().getUpdateStatus() == CheckVersionResult.HAVE_NEW_VERSION_FORCED_UPLOAD) {
                        updateEntity.setForce(true);
                    }
                    updateEntity.setHasUpdate(true)
                            .setUpdateContent(checkResult.getData().getUpdateInfo())
                            .setVersionCode(checkResult.getData().getVersion())
                            .setVersionName(checkResult.getData().getName())
                            .setDownloadUrl(checkResult.getData().getUrl())
                            .setSize(checkResult.getData().getSize())
                            .setMd5(checkResult.getData().getApkMd5());
                }
                return updateEntity;

            }
        }
        return null;
    }

    /**
     * 进行本地版本判断[防止服务端出错，本来是不需要更新，但是服务端返回是需要更新]
     *
     * @param checkResult
     * @return
     */
    private CheckVersionResult doLocalCompare(CheckVersionResult checkResult) {
        int lastVersionCode = checkResult.getData().getVersion();
        if (lastVersionCode <= UpdateUtils.getVersionCode(XUpdate.getContext())) { //最新版本小于等于现在的版本，不需要更新
            checkResult.getData().setUpdateStatus(CheckVersionResult.NO_NEW_VERSION);
        } else {
            if (checkResult.getData().isUpdateForce()) {
                checkResult.getData().setUpdateStatus(CheckVersionResult.HAVE_NEW_VERSION_FORCED_UPLOAD);
            } else {
                checkResult.getData().setUpdateStatus(CheckVersionResult.HAVE_NEW_VERSION);
            }
        }
        return checkResult;
    }
}
