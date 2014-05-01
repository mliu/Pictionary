package com.example.pictionary;

import android.util.AttributeSet;

import android.content.Context;

import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

// -------------------------------------------------------------------------
/**
 * View in charge of user drawing
 *
 * @author Michael Liu
 * @version Apr 10, 2014
 */
public class DrawingView extends View {
    // drawing path
    private Path drawPath;
    // drawing and canvas paint
    private Paint drawPaint, canvasPaint;
    // initial color
    private int paintColor = 0xFF000000;
    // canvas
    private Canvas drawCanvas;
    // canvas bitmap
    private Bitmap canvasBitmap;
    // drawing queue
    private DrawQueue<DrawObject> queue;

    // ----------------------------------------------------------
    /**
     * Create a new DrawingView object.
     *
     * @param context
     *            Context of this drawing view
     * @param attrs
     *            Set of attributes of this drawing view
     */
    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    // ----------------------------------------------------------
    /**
     * Passes the queue from the controller onto this queue
     * @param q the queue to be set
     */
    public void setQueue(DrawQueue<DrawObject> q) {
        queue = q;
    }

    // ----------------------------------------------------------
    /**
     * Sets up the drawing stage
     */
    public void setupDrawing() {
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    // ----------------------------------------------------------
    /**
     * Listens for touch events on the view
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        DrawObject d;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                d = new DrawObject(paintColor, touchX, touchY, MotionEvent.ACTION_DOWN);
                queue.add(d);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                d = new DrawObject(paintColor, touchX, touchY, MotionEvent.ACTION_MOVE);
                queue.add(d);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                d = new DrawObject(paintColor, touchX, touchY, MotionEvent.ACTION_UP);
                queue.add(d);
                drawPath.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    // ----------------------------------------------------------
    /**
     * Called when the custom view is assigned a size
     *
     * @param w
     *            new Width
     * @param h
     *            new Height
     * @param oldw
     *            old Width
     * @param oldh
     *            old Height
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    // ----------------------------------------------------------
    /**
     * Triggers when the user draws on the view
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    // ----------------------------------------------------------
    /**
     * Gets the queue from this DrawingView
     * @return queue of drawobjects
     */
    public DrawQueue<DrawObject> getQueue(){
        return queue;
    }
}
