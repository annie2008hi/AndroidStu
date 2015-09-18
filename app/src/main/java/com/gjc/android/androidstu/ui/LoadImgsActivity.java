package com.gjc.android.androidstu.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.gjc.android.androidstu.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by gjc on 2015/8/25.
 */
public class LoadImgsActivity extends Activity {
    private ImageLoader mImgsLoader = ImageLoader.getInstance();
    private ImageView mImgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_imgs);

        initImgLoaderConfig();
        mImgs = (ImageView) findViewById(R.id.imgs);
        loadImages(mImgs);

    }
    private void loadImages(ImageView imageView){
        //system path to save images
        File cacheDir = StorageUtils.getOwnCacheDirectory(
                this,"data");
        DisplayImageOptions imageOptions = new
                DisplayImageOptions.Builder()
                .cacheInMemory()
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new
                ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(5)
                .threadPriority(Thread.NORM_PRIORITY - 1)
                .build();


//        .threadPriority(Thread.NORM_PRIORITY - 1)
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .denyCacheImageMultipleSizesInMemory()
//                .memoryCache(new LruMemoryCache(1024 * 1024))
//                .memoryCacheSize(1 * 1024 * 1024)
//                .discCache(new UnlimitedDiscCache(cacheDir)) // default
//                .discCacheSize(20 * 1024 * 1024)
//                .discCacheFileCount(400)
//                .discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
//                .imageDownloader(new BaseImageDownloader(MainActivity.this)) // default
//                .imageDecoder(new BaseImageDecoder()) // default
//                .defaultDisplayImageOptions(imageOptions) // default
//                .enableLogging().build();









        mImgsLoader.init(config);
        mImgsLoader.displayImage("http://www.baidu.com/img/bdlogo.gif",
                mImgs);
    }
    private void initImgLoaderConfig(){
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//                .build();
//        ImageLoader.getInstance().init(config);


        // DON'T COPY THIS CODE TO YOUR PROJECT! This is just example of ALL options using.
        // See the sample project how to use ImageLoader correctly.
//        File cacheDir = StorageUtils.getCacheDirectory(this);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
//                .diskCacheExtraOptions(480, 800, null)
////                .taskExecutor(...)
////        .taskExecutorForCachedImages(...)
//        .threadPoolSize(3) // default
//                .threadPriority(Thread.NORM_PRIORITY - 2) // default
//                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
//                .denyCacheImageMultipleSizesInMemory()
//                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
//                .memoryCacheSize(2 * 1024 * 1024)
//                .memoryCacheSizePercentage(13) // default
////                .diskCache(new UnlimitedDiscCache(cacheDir)) // default
//                .diskCacheSize(50 * 1024 * 1024)
//                .diskCacheFileCount(100)
//                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
//                .imageDownloader(new BaseImageDownloader(this)) // default
////                .imageDecoder(new BaseImageDecoder()) // default
//                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
//                .writeDebugLogs()
//                .build();




//        Display Options (DisplayImageOptions) are local for every display task
// (ImageLoader.displayImage(...)).
//        Display Options can be applied to every display task
// (ImageLoader.displayImage(...) call).
//        Note: If Display Options wasn't passed to
// ImageLoader.displayImage(...)method then default Display Options
// from configuration (ImageLoaderConfiguration.defaultDisplayImageOptions(...))
// will be used.


//       // DON'T COPY THIS CODE TO YOUR PROJECT! This is just example of ALL options using.
//// See the sample project how to use ImageLoader correctly.
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.ic_stub) // resource or drawable
//                .showImageForEmptyUri(R.drawable.ic_empty) // resource or drawable
//                .showImageOnFail(R.drawable.ic_error) // resource or drawable
//                .resetViewBeforeLoading(false)  // default
//                .delayBeforeLoading(1000)
//                .cacheInMemory(false) // default
//                .cacheOnDisk(false) // default
//                .preProcessor(...)
//        .postProcessor(...)
//        .extraForDownloader(...)
//        .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
//                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .decodingOptions(...)
//        .displayer(new SimpleBitmapDisplayer()) // default
//                .handler(new Handler()) // default
//                .build();
    }
}
