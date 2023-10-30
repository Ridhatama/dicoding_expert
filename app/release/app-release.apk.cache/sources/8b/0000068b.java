package p0;

import h3.e;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public int f4819a;

    /* renamed from: b  reason: collision with root package name */
    public int f4820b;

    /* renamed from: c  reason: collision with root package name */
    public int f4821c;

    /* renamed from: d  reason: collision with root package name */
    public Object f4822d;

    public c() {
        if (e.f3348h == null) {
            e.f3348h = new e();
        }
    }

    public final int a(int i2) {
        if (i2 < this.f4821c) {
            return ((ByteBuffer) this.f4822d).getShort(this.f4820b + i2);
        }
        return 0;
    }

    public final void b(int i2, ByteBuffer byteBuffer) {
        short s7;
        this.f4822d = byteBuffer;
        if (byteBuffer != null) {
            this.f4819a = i2;
            int i4 = i2 - byteBuffer.getInt(i2);
            this.f4820b = i4;
            s7 = ((ByteBuffer) this.f4822d).getShort(i4);
        } else {
            s7 = 0;
            this.f4819a = 0;
            this.f4820b = 0;
        }
        this.f4821c = s7;
    }
}