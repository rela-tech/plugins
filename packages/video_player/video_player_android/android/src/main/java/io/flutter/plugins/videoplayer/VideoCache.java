package io.flutter.plugins.videoplayer;

import android.content.Context;

import com.google.android.exoplayer2.database.StandaloneDatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;

import java.io.File;

public class VideoCache {
    private static SimpleCache sDownloadCache;

    public static SimpleCache getInstance(Context context) {
        if (sDownloadCache == null) sDownloadCache = new SimpleCache(
                new File(context.getCacheDir(), "moment_videos"),
                new LeastRecentlyUsedCacheEvictor(1024L * 1024L * 512L),
                new StandaloneDatabaseProvider(context));
        return sDownloadCache;
    }
}
