package com.example.liberty.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.example.liberty.R;

public class TestView extends View {
    private static final String TAG = "TestView";
    //不能设置默认值时，就可以使用for循环的形式来获取值
    private String taString = "默认显示";
    private Paint mPaint;

    public TestView(Context context) {
        super(context);
    }

    /**
     * 需要两个值构造方法一以上才可以在xml中使用
     *
     * @param context
     * @param attrs
     */
    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        /**
         * 获取一个TypeArray
         */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TestView);
        boolean taBoolean = ta.getBoolean(R.styleable.TestView_text_boolean, false);
        //   String taString = ta.getString(R.styleable.TestView_text);
        int taInteger = ta.getInteger(R.styleable.TestView_text_integer, 0);
        float taDimension = ta.getDimension(R.styleable.TestView_str_dimension, -1);
        int taEnum = ta.getInt(R.styleable.TestView_text_enum, 1);

        /**
         * 只会获取用户设置值
         * 需要设置默认值值
         */
        int count = ta.getIndexCount();
        for (int i = 0; i < count; i++) {
            int index = ta.getIndex(i);
            switch (index) {
                case R.styleable.TestView_text:
                    taString = ta.getString(R.styleable.TestView_text);
                    break;
            }

        }

        //获取设置的属性值
        Log.i(TAG, "TestView:" +
                "\ttaBoolean:" + taBoolean +
                "\ttString:" + taString +
                "\ttaInteger:" + taInteger +
                "\ttaDimension:" + taDimension +
                "\ttaEnum:" + taEnum
        );
        ta.recycle(); //回收
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        /**
         * 这里所有的自定义空间：
         * 都可以需先获得 mode size
         *
         */
        //拿到父空间
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int width = 0;
        //用户自定了一个大小：
        /**
         * 根据不同的mode来确定宽度高度
         */
        if (mode == MeasureSpec.EXACTLY) {
            width = width;
        } else {

            //空间所需要的宽度
            int needWidth = measuredWidth() + getPaddingLeft() + getPaddingRight();
            //确定mode     自己测量的不能超高传入的值
            if (mode == MeasureSpec.AT_MOST) {  //最多
                //取最小值
                width = Math.min(needWidth, size);
            } else {
                //直接使用测量得到值
                width = needWidth;
            }
        }
        setMeasuredDimension(width, heightMeasureSpec);
        Log.i(TAG, "onMeasure: " + width + ":" + heightMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int height = 0;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            //高度： 自己高度再加上下边距
            int needHeight = measuredHeight() + getPaddingTop() + getPaddingBottom();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, needHeight);
            } else { //MeasureSpec.UNSPECIFIED  测量有多大就多大
                height = needHeight;
            }
            //
        }
         super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }


    public int measuredWidth() {
        return 0;
    }

    public int measuredHeight() {
        return 0;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mPaint.setColor(0xFFFF0000);

        //去除锯齿
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //   super.onDraw(canvas);
        canvas.drawCircle(
                getWidth() / 2,
                getHeight() / 2,
                getWidth() / 2 - mPaint.getStrokeWidth() / 2, mPaint);
        mPaint.setStrokeWidth(1);
        setFOilter();
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mPaint);
        Rect rect = new Rect();
        rect.height();
        rect.width();
        rect.set(20, 30, 45, 20);
        canvas.drawRect(rect, mPaint);
        /**
         * 显示文本
         */
        mPaint.setStrokeWidth(0);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        canvas.drawText(taString, 0, taString.length(), 0, getHeight(), mPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        taString = "8888888";
        invalidate();  //重绘
        return true;
    }

    public static final String INSTANCE_KEY = "instance";
    public static final String KEY_TXT = "key_text";

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_KEY, super.onSaveInstanceState());
        bundle.putString(KEY_TXT, taString);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            Parcelable parcelable = bundle.getParcelable(INSTANCE_KEY);
            super.onRestoreInstanceState(parcelable);
            taString = bundle.getString(KEY_TXT);
            return;
        }
        super.onRestoreInstanceState(state);
    }

    /***
     * 注释方法
     */
    private void setFOilter() {

    }
}