package com.example.liberty.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import com.example.liberty.R;

public class RoundProgressBar extends View {
    private int mRadius; //半径
    private int mColor;
    private int mLineHeight;
    private int mTextSize;
    private int mProgress = 0;
    private Paint mPaint;
    private RectF rectF;


    public RoundProgressBar(Context context) {
        super(context);
    }

    public RoundProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public RoundProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundProgressBar);
        //获取设置的属性值
        mRadius = (int) ta.getDimension(R.styleable.RoundProgressBar_radius, dp2px(30));
        mColor = ta.getColor(R.styleable.RoundProgressBar_color, 0xffff0000);
        mLineHeight = (int) ta.getDimension(R.styleable.RoundProgressBar_line_width, dp2px(3));
        mTextSize = (int) ta.getDimension(R.styleable.RoundProgressBar_android_textSize, dp2px(16));

        mProgress = ta.getInteger(R.styleable.RoundProgressBar_android_progress, 0);

        ta.recycle();
        initPaint();
    }

    private float dp2px(int dpVal) {
        return TypedValue.
                applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        dpVal, getResources().getDisplayMetrics());
    }

    private void initPaint() {
        mPaint = new Paint();
        //抗锯齿
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);

    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            Parcelable parcelable = bundle.getParcelable(KEY_INSTANCE);
            mProgress = bundle.getInt(KEY_PROGRESS);
            super.onRestoreInstanceState(parcelable);
            return;
        }
        //默认
        super.onRestoreInstanceState(state);
    }

    public static final String KEY_INSTANCE = "instance_key";
    public static final String KEY_PROGRESS = "progress_key";

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PROGRESS, mProgress);
        bundle.putParcelable(KEY_INSTANCE, super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        绘制进度
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mLineHeight * 1.0f / 4);
//        mPaint.setStrokeWidth(1);
        int width = getWidth();
        int height = getHeight();
//        mRadius

        canvas.drawCircle(width / 2,
                height / 2,
                width / 2 - getPaddingLeft() - mPaint.getStrokeWidth() / 2,
                mPaint);
        mPaint.setStrokeWidth(mLineHeight);
        canvas.save();

        canvas.translate(getPaddingLeft(), getPaddingTop());
        float angle = mProgress * 1.0f / 100 * 360;
        //圆弧的绘制
        canvas.drawArc(rectF,
                0, angle,
                false, mPaint);
        canvas.restore();
        String text = mProgress + "%";// "绘梦"; //
        mPaint.setStrokeWidth(0);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(mTextSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        int textHeight = rect.height();  //文本高度
        int y = getHeight() / 2;
        mPaint.setStrokeWidth(0);
        canvas.drawText(text, 0, text.length(), getWidth() / 2, y + textHeight / 2, mPaint);
        mPaint.setStrokeWidth(0);
        mPaint.setStyle(Paint.Style.FILL);
        //
        canvas.drawLine(getWidth() / 2, 0 + getPaddingTop(), getWidth() / 2, getHeight() - getPaddingBottom(), mPaint);
        //X轴：0开始——高度的一半   y轴开始位置为高度的一半，结束位置为
        canvas.drawLine(0 + getPaddingLeft(), getHeight() / 2, getWidth() - getPaddingRight(), getHeight() / 2, mPaint);
    }

    public void setProgress(int progress) {
        mProgress = progress;
        invalidate();
    }

    public int getProgress() {
        return mProgress;
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF = new RectF(0, 0,
                w - getPaddingLeft() * 2,
                h - getPaddingLeft() * 2);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int width = 0;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            int needWidth = measuredWidth() + getPaddingRight() + getPaddingLeft();
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(needWidth, widthSize);
            } else {
                // MeasureSpec.UNSPECIFIED
                width = needWidth;
            }
        }
        //高度
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int height = 0;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            int needHeight = measuredWidth() + getPaddingBottom() + getPaddingTop();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(needHeight, heightSize);
            } else {
                height = needHeight;
            }
        }

        //保持高度和宽度一致
        width = Math.min(width, height);
        setMeasuredDimension(width, width);

    }

    private int measuredWidth() {
        return mRadius;
    }

    private int measuredHeight() {
        return mRadius;
    }
}
