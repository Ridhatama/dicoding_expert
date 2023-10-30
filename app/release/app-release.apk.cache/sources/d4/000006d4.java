package q2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b3.i;
import b3.j;
import com.iftah.movieapp.R;
import e3.d;
import h3.h;
import h3.l;
import h5.u;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes.dex */
public final class a extends Drawable implements i {

    /* renamed from: h  reason: collision with root package name */
    public final WeakReference f5063h;

    /* renamed from: i  reason: collision with root package name */
    public final h f5064i;

    /* renamed from: j  reason: collision with root package name */
    public final j f5065j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f5066k;

    /* renamed from: l  reason: collision with root package name */
    public final c f5067l;

    /* renamed from: m  reason: collision with root package name */
    public float f5068m;

    /* renamed from: n  reason: collision with root package name */
    public float f5069n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public float f5070p;

    /* renamed from: q  reason: collision with root package name */
    public float f5071q;

    /* renamed from: r  reason: collision with root package name */
    public float f5072r;

    /* renamed from: s  reason: collision with root package name */
    public WeakReference f5073s;

    /* renamed from: t  reason: collision with root package name */
    public WeakReference f5074t;

    public a(Context context, b bVar) {
        int intValue;
        int intValue2;
        int i2;
        FrameLayout frameLayout;
        d dVar;
        WeakReference weakReference = new WeakReference(context);
        this.f5063h = weakReference;
        u.p(context, u.f3510b, "Theme.MaterialComponents");
        this.f5066k = new Rect();
        j jVar = new j(this);
        this.f5065j = jVar;
        TextPaint textPaint = jVar.f1401a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        c cVar = new c(context, bVar);
        this.f5067l = cVar;
        boolean e7 = e();
        b bVar2 = cVar.f5094b;
        if (e7) {
            intValue = bVar2.f5081n.intValue();
        } else {
            intValue = bVar2.f5079l.intValue();
        }
        if (e()) {
            intValue2 = bVar2.o.intValue();
        } else {
            intValue2 = bVar2.f5080m.intValue();
        }
        h hVar = new h(new l(l.a(context, intValue, intValue2, new h3.a(0))));
        this.f5064i = hVar;
        g();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && jVar.f1407g != (dVar = new d(context2, bVar2.f5078k.intValue()))) {
            jVar.b(dVar, context2);
            textPaint.setColor(bVar2.f5077j.intValue());
            invalidateSelf();
            i();
            invalidateSelf();
        }
        int i4 = bVar2.f5085s;
        if (i4 != -2) {
            i2 = ((int) Math.pow(10.0d, i4 - 1.0d)) - 1;
        } else {
            i2 = bVar2.f5086t;
        }
        this.o = i2;
        jVar.f1405e = true;
        i();
        invalidateSelf();
        jVar.f1405e = true;
        g();
        i();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(bVar2.f5076i.intValue());
        if (hVar.f3377h.f3359c != valueOf) {
            hVar.k(valueOf);
            invalidateSelf();
        }
        textPaint.setColor(bVar2.f5077j.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f5073s;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.f5073s.get();
            WeakReference weakReference3 = this.f5074t;
            if (weakReference3 != null) {
                frameLayout = (FrameLayout) weakReference3.get();
            } else {
                frameLayout = null;
            }
            h(view, frameLayout);
        }
        i();
        setVisible(bVar2.A.booleanValue(), false);
    }

    @Override // b3.i
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        boolean z2;
        c cVar = this.f5067l;
        b bVar = cVar.f5094b;
        String str = bVar.f5083q;
        if (str != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        WeakReference weakReference = this.f5063h;
        if (z2) {
            int i2 = bVar.f5085s;
            if (i2 != -2 && str != null && str.length() > i2) {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    return "";
                }
                str = String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i2 - 1), "…");
            }
            return str;
        } else if (f()) {
            if (this.o != -2 && d() > this.o) {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    return "";
                }
                return String.format(cVar.f5094b.f5087u, context2.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.o), "+");
            }
            return NumberFormat.getInstance(cVar.f5094b.f5087u).format(d());
        } else {
            return null;
        }
    }

    public final FrameLayout c() {
        WeakReference weakReference = this.f5074t;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public final int d() {
        boolean z2;
        int i2 = this.f5067l.f5094b.f5084r;
        if (i2 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return 0;
        }
        return i2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String b7;
        int round;
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f5064i.draw(canvas);
            if (e() && (b7 = b()) != null) {
                Rect rect = new Rect();
                j jVar = this.f5065j;
                jVar.f1401a.getTextBounds(b7, 0, b7.length(), rect);
                float exactCenterY = this.f5069n - rect.exactCenterY();
                float f7 = this.f5068m;
                if (rect.bottom <= 0) {
                    round = (int) exactCenterY;
                } else {
                    round = Math.round(exactCenterY);
                }
                canvas.drawText(b7, f7, round, jVar.f1401a);
            }
        }
    }

    public final boolean e() {
        boolean z2;
        if (this.f5067l.f5094b.f5083q != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || f()) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        boolean z2;
        boolean z6;
        b bVar = this.f5067l.f5094b;
        if (bVar.f5083q != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            if (bVar.f5084r != -1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                return true;
            }
        }
        return false;
    }

    public final void g() {
        int intValue;
        int intValue2;
        Context context = (Context) this.f5063h.get();
        if (context == null) {
            return;
        }
        boolean e7 = e();
        c cVar = this.f5067l;
        if (e7) {
            intValue = cVar.f5094b.f5081n.intValue();
        } else {
            intValue = cVar.f5094b.f5079l.intValue();
        }
        if (e()) {
            intValue2 = cVar.f5094b.o.intValue();
        } else {
            intValue2 = cVar.f5094b.f5080m.intValue();
        }
        this.f5064i.setShapeAppearanceModel(new l(l.a(context, intValue, intValue2, new h3.a(0))));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f5067l.f5094b.f5082p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f5066k.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f5066k.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h(View view, FrameLayout frameLayout) {
        this.f5073s = new WeakReference(view);
        this.f5074t = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        i();
        invalidateSelf();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0172, code lost:
        if (g0.h0.d(r2) == 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017b, code lost:
        if (g0.h0.d(r2) == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017d, code lost:
        r3 = (r5.left - r14.f5071q) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0186, code lost:
        r3 = (r5.right + r14.f5071q) - r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.a.i():void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, b3.i
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        c cVar = this.f5067l;
        cVar.f5093a.f5082p = i2;
        cVar.f5094b.f5082p = i2;
        this.f5065j.f1401a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}