package com.dunst.check;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

/**
 * Created by ashok.kumar on 19/09/16.
 */

public class CheckableImageButton extends ImageButton implements Checkable {

    private boolean checked;
    private boolean broadcasting;

    private OnCheckedChangeListener onCheckedChangeListener;

    private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        int[] set = {
                android.R.attr.checked, // idx 0
        };
        TypedArray a = context.obtainStyledAttributes(attrs, set);

        boolean checked = a.getBoolean(0, false);
        setChecked(checked);

        a.recycle();
    }

    public void toggle() {
        setChecked(!checked);
    }

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public boolean isChecked() {
        return checked;
    }

    /**
     * <p>
     * Changes the checked state of this button.
     * </p>
     *
     * @param checked
     *            true to check the button, false to uncheck it
     */
    public void setChecked(boolean checked) {
        if (this.checked != checked) {
            this.checked = checked;
            refreshDrawableState();

            // Avoid infinite recursions if setChecked() is called from a listener
            if (broadcasting) {
                return;
            }

            broadcasting = true;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.checked);
            }

            broadcasting = false;
        }
    }

    /**
     * Register a callback to be invoked when the checked state of this button changes.
     *
     * @param listener
     *            the callback to call on checked state change
     */
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        onCheckedChangeListener = listener;
    }

    /**
     * Interface definition for a callback.
     */
    public static interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a button has changed.
         *
         * @param button
         *            The button view whose state has changed.
         * @param isChecked
         *            The new checked state of button.
         */
        void onCheckedChanged(CheckableImageButton button, boolean isChecked);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    static class SavedState extends BaseSavedState {
        boolean checked;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            checked = (Boolean) in.readValue(null);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(checked);
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.checked = isChecked();
        return ss;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;

        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
        requestLayout();
    }
}