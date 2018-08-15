package com.freeler.imageloader;

import android.content.Context;
import android.view.View;

import org.jetbrains.annotations.NotNull;

/**
 * 接口策略
 *
 * @author xuzeyang
 * @date 2017/10/26
 */
public interface IImageLoaderStrategy {

    void showImage(@NotNull ImageLoaderOptions options);

    void hideImage(@NotNull View view, int visible);

    void cleanMemory(Context context);

    void pause(Context context);

    void resume(Context context);

    /**
     * 在application的onCreate中初始化
     *
     * @param context
     */
    void init(Context context);

}
