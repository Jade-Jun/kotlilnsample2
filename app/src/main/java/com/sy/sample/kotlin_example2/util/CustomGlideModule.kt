package com.sy.sample.kotlin_example2.util

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.GlideModule

/**
 * Created by SuYa on 2017. 9. 7..
 */
class CustomGlideModule : GlideModule {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(30 * 1024 * 1024)).setDecodeFormat(
                DecodeFormat.PREFER_ARGB_8888)
    }

    override fun registerComponents(context: Context?, glide: Glide?, registry: Registry?) {
        
    }
    
}