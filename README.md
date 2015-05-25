# SemiCircle
Create a semiCircle using code


###效果图
------------------------------------------------------
<br>
<img src="https://github.com/sunalong/sources/blob/master/semicircle.png" width="240">

###思路
------------------------------------------------------
#####1.绘制最外一层矩形(红色区域):<br>
    ①：初始化画笔(在构造方法中)
```java
    outRectPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    outRectPaint.setColor(0xFFFF0000);
    outRectPaint.setStyle(Paint.Style.FILL);
```
    ②：设置大小(在方法onSizeChanged中)：
		
```java
    outRect = new RectF(getPaddingLeft(), getPaddingTop(), w-getPaddingRight(), h-getPaddingBottom());
```
    ③：画矩形(在方法onDraw中)：
```java
    canvas.drawRect(outRect, outRectPaint);
```
#####2.绘制容纳半圆的矩形：

    ①：初始化画笔(在构造方法中)
```java
    insideRectPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    insideRectPaint.setColor(0x0000FF00);
    insideRectPaint.setStyle(Paint.Style.STROKE);
```
    ②：设置大小(在方法onSizeChanged中)：
```java
    float insideRectDownH = dimension-getPaddingBottom()-getPaddingTop()+150;
    insideRect = new RectF(w/2-radius, h-radius-getPaddingTop(), w/2+radius,  h+radius-getPaddingBottom());
```
    ③：画矩形(在方法onDraw中)：
```java
    canvas.drawRect(insideRect, insideRectPaint);
```
	    	
#####3.绘制半圆：

    ①：初始化画笔(在构造方法中)
```java
    semiCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    semiCirclePaint.setColor(0xFFFFFFFF);
    semiCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
```
    ②：画矩形(在方法onDraw中)：
```java
    canvas.drawArc(insideRect, 180, 180, false, semiCirclePaint);
```
###使用方法
------------------------------------------------------
#####在布局中：
```xml
<com.itcode.semiCircle.MyDrawSemicircle
    android:layout_width="200dp"
    android:layout_height="100dp"
    android:layout_marginTop="10dp"
    android:paddingBottom="10dp"
    android:paddingLeft="10dp"
    android:paddingRight="10dp"
    android:paddingTop="10dp" />
```
