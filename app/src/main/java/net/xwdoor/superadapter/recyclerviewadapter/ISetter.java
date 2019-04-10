package net.xwdoor.superadapter.recyclerviewadapter;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.FloatRange;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;

/**
 *  ViewHolder的设置方法
 */
public interface ISetter<ViewHolder> {
    ViewHolder setText(int viewId, CharSequence text);

    ViewHolder setTextColor(int viewId, int textColor);

    ViewHolder setTextColor(int viewId, ColorStateList colorStateList);

    ViewHolder setMovementMethod(int viewId, MovementMethod method);

    ViewHolder setImageResource(int viewId, int imgResId);

    ViewHolder setImageDrawable(int viewId, Drawable drawable);

    ViewHolder setImageBitmap(int viewId, Bitmap bitmap);

    ViewHolder setImageUri(int viewId, Uri imageUri);

    ViewHolder setScaleType(int viewId, ImageView.ScaleType type);

    ViewHolder setBackgroundColor(int viewId, int bgColor);

    ViewHolder setBackgroundResource(int viewId, int bgRes);

    ViewHolder setColorFilter(int viewId, ColorFilter colorFilter);

    ViewHolder setColorFilter(int viewId, int colorFilter);

    ViewHolder setAlpha(int viewId, @FloatRange(from = 0.0, to = 1.0) float value);

    ViewHolder setVisibility(int viewId, int visibility);

    ViewHolder setMax(int viewId, int max);

    ViewHolder setProgress(int viewId, int progress);

    ViewHolder setRating(int viewId, float rating);

    ViewHolder setTag(int viewId, Object tag);

    ViewHolder setTag(int viewId, int key, Object tag);

    ViewHolder setEnabled(int viewId, boolean enabled);

    ViewHolder setAdapter(int viewId, Adapter adapter);

    ViewHolder setChecked(int viewId, boolean checked);

    ViewHolder setOnClickListener(int viewId, View.OnClickListener listener);

    ViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener);

    ViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener);
}
