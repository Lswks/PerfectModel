package com.example.bigmercu.perfectmodel.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutionException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by bigmercu on 2016/9/5.
 * Email: bigmercu@gmail.com
 */

public class CustomAvatar extends View {
    private static final String TAG = CustomAvatar.class.getSimpleName();
    private int mScreenH;
    private int mScreenW;
    private Paint mPaint;
    private Bitmap mBitmap;
    private String avaterUrl = "https://avatars.githubusercontent.com/u/8034315?v=3";
    private Path mPath;

    public CustomAvatar(Context context) {
        super(context);
    }

    public CustomAvatar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomAvatar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomAvatar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mScreenH = h;
        this.mScreenW = w;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);


        mPath = new Path();

        Observable.just(avaterUrl)
                .observeOn(Schedulers.io())
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        try {
                            return Glide.with(getContext()).load(s).asBitmap()
                                    .override(180,180)
                                    .into(-1,-1)
                                    .get();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        mBitmap = bitmap;
                        postInvalidate();
                    }
                });

    }

    @SuppressWarnings("all")
    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            int radius = mBitmap.getWidth() / 2;
            BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            mPaint.setShader(bitmapShader);
            Rect rect = new Rect(0,0,mScreenW,mScreenH);
            RectF rectF = new RectF(rect);
            canvas.drawCircle(mScreenW/2,mScreenH/2,mScreenW/2,mPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int wMod = MeasureSpec.getMode(widthMeasureSpec);
        int hMod = MeasureSpec.getMode(heightMeasureSpec);

        if(wMod == MeasureSpec.AT_MOST && hMod == MeasureSpec.AT_MOST){
            setMeasuredDimension(dp2px(60),dp2px(60));
        }else if(wMod == MeasureSpec.AT_MOST){
            setMeasuredDimension(dp2px(60),h);
        }else if(hMod == MeasureSpec.AT_MOST){
            setMeasuredDimension(w,dp2px(60));
        }
    }

    public int dp2px(float value) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (value * density + 0.5f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
