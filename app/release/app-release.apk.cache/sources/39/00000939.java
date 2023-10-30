package z4;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class b implements e5.a, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public transient e5.a f6916h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f6917i;

    /* renamed from: j  reason: collision with root package name */
    public final Class f6918j;

    /* renamed from: k  reason: collision with root package name */
    public final String f6919k;

    /* renamed from: l  reason: collision with root package name */
    public final String f6920l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f6921m;

    public b(Object obj, Class cls, String str, String str2, boolean z2) {
        this.f6917i = obj;
        this.f6918j = cls;
        this.f6919k = str;
        this.f6920l = str2;
        this.f6921m = z2;
    }

    public final c b() {
        Class cls = this.f6918j;
        if (cls == null) {
            return null;
        }
        if (this.f6921m) {
            n.f6932a.getClass();
            return new i(cls);
        }
        return n.a(cls);
    }
}