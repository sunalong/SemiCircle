package com.itcode.semiCircle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
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
	private float radius = 100;
	private float insideLeft;
	private float insideRight;
	private float insideTop;
	private float insideBottom;
	/**
	 * �߿����ڵľ���
	 */
	private RectF mBorderRect = new RectF();
	/**
	 * �߿�Ļ���
	 */
	private Paint mBorderPaint;
	/**
	 * Բ��ͷ��ı߿��ϸ
	 */
	private float borderWidth = 5;

	public MyDrawSemicircle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		outRectPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
		outRectPaint.setColor(0xFFFF0000);
		outRectPaint.setStyle(Paint.Style.FILL);

		insideRectPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
		// insideRectPaint.setColor(0x0000FF00);
		insideRectPaint.setColor(0xFF00FF00);
		insideRectPaint.setStyle(Paint.Style.STROKE);

		semiCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		semiCirclePaint.setColor(0xFFFFFFFF);
		semiCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

		mBorderPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
		mBorderPaint.setStyle(Paint.Style.STROKE);
		mBorderPaint.setColor(0xFF00FF00);
		mBorderPaint.setStrokeWidth(borderWidth);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(outRect, outRectPaint);// ������
		canvas.drawRect(insideRect, insideRectPaint);
		// canvas.drawArc(insideRect, 180, 180, false, semiCirclePaint);// ����Բ
		canvas.drawArc(insideRect, 0, 360, false, semiCirclePaint);// ����Բ
		//��Բ�α߿�
//		canvas.drawCircle(insideLeft + radius, insideRight - radius - 3 * getPaddingRight() + borderWidth, radius, mBorderPaint);
		canvas.drawCircle(insideLeft + radius, insideBottom-radius, radius, mBorderPaint);
		
		Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.testqn);
		Log.i("semiCircle:","===========bitmap:"+bitmap);
		
		/**
		 * �ü�bitmap
		 */
		Path path = new Path();
//		path.addCircle(radius, radius, radius, Path.Direction.CW);
		path.addCircle(insideLeft + radius, insideBottom-radius, radius, Path.Direction.CW);
		canvas.clipPath(path);
		//TODO:����bitmap��ʹ֮��������ʾ��Բ�ο���
		canvas.drawBitmap(bitmap, new Matrix(), mBorderPaint);
	}



	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		// super.onSizeChanged(w, h, oldw, oldh);
		float xPad = getPaddingLeft() + getPaddingRight();
		float yPad = getPaddingTop() + getPaddingBottom();
		dimension = Math.min(w - xPad, (h - yPad) * 2);
		insideLeft = w / 2 - radius;
		insideRight = w / 2 + radius;
		insideTop = dimension - getPaddingBottom() - radius;
		insideBottom = h - getPaddingBottom();

		outRect = new RectF(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom());
		float insideRectDownH = dimension - getPaddingBottom() - getPaddingTop() + 150;
		// insideRect = new RectF(w/2-radius, h-radius-getPaddingTop(),
		// w/2+radius, h+radius-getPaddingBottom());
		insideRect = new RectF(w / 2 - radius, h - 2 * radius - getPaddingTop(), w / 2 + radius, h - getPaddingBottom());
		// insideRect = new RectF(w/2-radius, h-getPaddingTop(), w/2+radius,
		// h-getPaddingBottom());
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
	
	/**
	 * ��Բ�α߿�������ͼƬ
	 * @param bitmap
	 */
	public void setImageBitmap(Bitmap bitmap) {
		Bitmap destBitmap = Bitmap.createBitmap((int)radius, (int)radius, bitmap.getConfig());
		Canvas canvas = new Canvas(destBitmap);
		Log.i("semiCircle:","=================:"+(int)radius);
		Log.i("semiCircle:","===========canvas:"+canvas);
		canvas.drawBitmap(bitmap, new Matrix(), mBorderPaint);
		Log.i("semiCircle:","===========canvas:"+canvas);
//		canvas.save();
//		canvas.
	}
	
}
