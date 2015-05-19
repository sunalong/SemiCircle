package com.itcode.semiCircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyDrawSemicircle extends View {

	/**
	 * ��Բʹ�õĻ���
	 */
	private Paint insideRectPaint;
	/**
	 * ��Բʹ�õĻ���
	 */
	private Paint semiCirclePaint;
	/**
	 * ����һ�����ʹ�õĻ���
	 */
	private Paint outRectPaint;
	private float dimension;
	/**
	 * ����һ��ľ���
	 */
	private RectF outRect;
	/**
	 * �޶���Բ��С�ľ���
	 */
	private RectF insideRect;
	/**
	 * ��Բ�İ뾶
	 */
	private float radius;
	private float insideLeft;
	private float insideRight;
	private float insideTop;
	private float insideBottom;

	public MyDrawSemicircle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		outRectPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
		outRectPaint.setColor(0xFFFF0000);
		outRectPaint.setStyle(Paint.Style.FILL);
		
		insideRectPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
		insideRectPaint.setColor(0x0000FF00);
//		insideRectPaint.setColor(0xFF00FF00);
		insideRectPaint.setStyle(Paint.Style.STROKE);
		
		semiCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//		semiCirclePaint.setColor(0xFF0000FF);
		semiCirclePaint.setColor(0xFFFFFFFF);
		semiCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(outRect, outRectPaint);// ������
		canvas.drawRect(insideRect, insideRectPaint);
		canvas.drawArc(insideRect, 180, 180, false, semiCirclePaint);// ����Բ
//		canvas.drawArc(outRect, 180, 180, false, semiCirclePaint);// ����Բ
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		// super.onSizeChanged(w, h, oldw, oldh);
		float xPad = getPaddingLeft() + getPaddingRight();
		float yPad = getPaddingTop() + getPaddingBottom();
		dimension = Math.min(w - xPad, (h - yPad) * 2);
		radius = 60;
		insideLeft = w / 2 - radius;
		insideRight = w / 2 + radius;
		insideTop = dimension - getPaddingBottom() - radius;
		insideBottom = dimension - getPaddingBottom();
		
		outRect = new RectF(getPaddingLeft(), getPaddingTop(), w-getPaddingRight(), h-getPaddingBottom());
		float insideRectDownH = dimension-getPaddingBottom()-getPaddingTop()+150;
		insideRect = new RectF(w/2-radius, h-radius-getPaddingTop(), w/2+radius,  h+radius-getPaddingBottom());
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int minw = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
		int measuredWidth = resolveSize(minw, widthMeasureSpec);

		int minh = getPaddingTop() + getPaddingBottom() + getSuggestedMinimumHeight();
		int measuredHeight = resolveSize(minh, heightMeasureSpec);
		setMeasuredDimension(measuredWidth, measuredHeight);
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}
}
