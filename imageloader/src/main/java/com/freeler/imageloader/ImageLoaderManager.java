package com.freeler.imageloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.freeler.imageloader.glideloader.GlideImageLoader;


/**
 * 图片管理manager - 在这里可以切换图片框架
 *
 * @author xuzeyang
 * @date 2017/10/26
 */
public class ImageLoaderManager implements IImageLoaderStrategy {

    private static final ImageLoaderManager INSTANCE = new ImageLoaderManager();
    private IImageLoaderStrategy loaderStrategy;

    private ImageLoaderManager() {
        loaderStrategy = new GlideImageLoader();
    }

    public static ImageLoaderManager getInstance() {
        return INSTANCE;
    }

    public void setImageLoaderStrategy(IImageLoaderStrategy strategy) {
        loaderStrategy = strategy;
    }

    /**
     *   可创建默认的Options设置，假如不需要使用ImageView ，
     *   请自行new一个ImageView传入即可
     *   内部只需要获取Context
     */
    public static ImageLoaderOptions getDefaultOptions(@NonNull View container, @NonNull String url) {
        return new ImageLoaderOptions.Builder(container, url).isCrossFade(true).build();
    }

    @Override
    public void showImage(@NonNull ImageLoaderOptions options) {
        if (loaderStrategy != null) {
            loaderStrategy.showImage(options);
        }
    }

    @Override
    public void hideImage(@NonNull View view, int visible) {
        if (loaderStrategy != null) {
            loaderStrategy.hideImage(view, visible);
        }
    }

    @Override
    public void cleanMemory(Context context) {
        loaderStrategy.cleanMemory(context);
    }

    @Override
    public void pause(Context context) {
        if (loaderStrategy != null) {
            loaderStrategy.pause(context);
        }
    }

    @Override
    public void resume(Context context) {
        if (loaderStrategy != null) {
            loaderStrategy.resume(context);
        }
    }

    // 在application的onCreate中初始化
    // 主要是Fresco框架需要初始化，Glide可以直接使用
    @Override
    public void init(Context context) {
//        loaderStrategy = new FrescoImageLoader();
        loaderStrategy = new GlideImageLoader();
        loaderStrategy.init(context);
    }

}
