#include "stdlib.h"

#include <jni.h>
#include "curses.h"

static JavaVM *jvm;

#define PDC_RGB 1

jlong pdcurses4j_initscr(JNIEnv *env, jobject that) {
  WINDOW* win = initscr();
  jlong peer = (jlong) win;
  return peer;
}

jint pdcurses4j_start_color(JNIEnv *env, jobject that) {
  return (jint) start_color();
}

jint pdcurses4j_init_pair(JNIEnv *env, jobject that, jshort pair, jshort fg, jshort bg) {
 return (jint) init_pair(pair, fg, bg);
}

jint pdcurses4j_wattr_on(JNIEnv *env, jobject that, jlong peer, jint attrs) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) wattr_on(win, attrs, NULL);
}

jint pdcurses4j_wrefresh(JNIEnv *env, jobject that, jlong peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) wrefresh(win);
}

jint pdcurses4j_wprintw(JNIEnv *env, jobject that, jlong peer, jstring str) {
 const char *_str = str == NULL ? NULL : (char *) (*env)->GetStringUTFChars(env, str, NULL);
 WINDOW* win = *(WINDOW **) &peer;
 jint ret = (jint) wprintw(win, _str);
 if (_str) {
  (*env)->ReleaseStringUTFChars(env, str, _str);
 }
 return ret;
}

jstring pdcurses4j_wgetnstr(JNIEnv *env, jobject that, jlong peer, jint n) {
 if (n <= 0) {
  return NULL;
 }
 WINDOW* win = *(WINDOW **) &peer;
 char *_str = malloc(sizeof(char) * (n + 1));
 if (wgetnstr(win, _str, n) > ERR) {
  jstring str = (*env)->NewStringUTF(env, _str);
  free(_str);
  return str;
 } else {
  free(_str);
  return NULL;
 }
}

jint pdcurses4j_endwin(JNIEnv *env, jobject that) {
 return endwin();
}

jint pdcurses4j_waddch(JNIEnv *env, jobject that, jlong peer, jchar ch) {
 WINDOW* win = *(WINDOW **) &peer;
 return waddch(win, ch);
}

jint pdcurses4j_wgetch(JNIEnv *env, jobject that, jlong peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return wgetch(win);
}

jint pdcurses4j_waddstr(JNIEnv *env, jobject that, jlong peer, jstring str) {
 const char *_str = str == NULL ? NULL : (char *) (*env)->GetStringUTFChars(env, str, NULL);
 WINDOW* win = *(WINDOW **) &peer;
 jint ret = (jint) waddstr(win, _str);
 if (_str) {
  (*env)->ReleaseStringUTFChars(env, str, _str);
 }
 return ret;
}

jint pdcurses4j_mvwaddstr(JNIEnv *env, jobject that, jlong peer, jint y, jint x, jstring str) {
 const char *_str = str == NULL ? NULL : (char *) (*env)->GetStringUTFChars(env, str, NULL);
 WINDOW* win = *(WINDOW **) &peer;
 jint ret = (jint) mvwaddstr(win, y, x, _str);
 if (_str) {
  (*env)->ReleaseStringUTFChars(env, str, _str);
 }
 return ret;
}

jint pdcurses4j_noecho(JNIEnv *env, jobject that) {
 return noecho();
}

jint pdcurses4j_nodelay(JNIEnv *env, jobject that, jlong peer, int bf) {
 WINDOW* win = *(WINDOW **) &peer;
 return nodelay(win, bf);
}

jint pdcurses4j_napms(JNIEnv *env, jobject that, jint delay) {
 return napms(delay);
}

jint pdcurses4j_mvwinsch(JNIEnv *env, jobject that, jint peer, jint y, jint x, jchar ch) {
 WINDOW* win = *(WINDOW **) &peer;
 return mvwinsch(win, y, x, ch);
}

jint pdcurses4j_mvwdelch(JNIEnv *env, jobject that, jint peer, jint y, jint x) {
 WINDOW* win = *(WINDOW **) &peer;
 return mvwdelch(win, y, x);
}

jstring pdcurses4j_unctrl(JNIEnv *env, jobject that, jint c) {
 const char *_str = unctrl(c);
 jstring str = NULL;
 if (_str) {
   str = (*env)->NewStringUTF(env, _str);
   return str;
 } else {
   return NULL;
 }
}

jint pdcurses4j_getmaxx(JNIEnv *env, jobject that, jint peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return getmaxx(win);
}

jint pdcurses4j_getmaxy(JNIEnv *env, jobject that, jint peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return getmaxy(win);
}

jint pdcurses4j_wclear(JNIEnv *env, jobject that, jint peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return wclear(win);
}

jint pdcurses4j_typeahead(JNIEnv *env, jobject that, jint fields) {
  return typeahead(fields);
}

jint pdcurses4j_def_shell_mode(JNIEnv *env, jobject that) {
  return def_shell_mode();
}

jlong pdcurses4j_newwin(JNIEnv *env, jobject that, jint nlines, jint ncols, jint begy, jint begx) {
 WINDOW* win = newwin(nlines, ncols, begy, begx);
 return (jlong) win;
}

jint pdcurses4j_getpary(JNIEnv *env, jobject that, jlong peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return getpary(win);
}

jint pdcurses4j_getparx(JNIEnv *env, jobject that, jlong peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return getparx(win);
}

jint pdcurses4j_wbkgd(JNIEnv *env, jobject that, jlong peer, jlong ch) {
 WINDOW* win = *(WINDOW **) &peer;
 return wbkgd(win, ch);
}

jlong pdcurses4j_subwin(JNIEnv *env, jobject that, jlong peer, jint nlines, jint ncols, jint begy, jint begx) {
 WINDOW* win = *(WINDOW **) &peer;
 WINDOW* sub = subwin(win, nlines, ncols, begy, begx);
 return (jlong) sub;
}

jint pdcurses4j_touchwin(JNIEnv *env, jobject that, jlong peer) {
 WINDOW* win = *(WINDOW **) &peer;
 return touchwin(win);
}

jlong pdcurses4j_derwin(JNIEnv *env, jobject that, jlong peer, jint nlines, jint ncols, jint begy, jint begx) {
 WINDOW* win = *(WINDOW **) &peer;
 WINDOW* sub = derwin(win, nlines, ncols, begy, begx);
 return (jlong) sub;
}

jint pdcurses4j_scrollok(JNIEnv *env, jobject that, jlong peer, int bf) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) scrollok(win, bf);
}

jint pdcurses4j_box(JNIEnv *env, jobject that, jlong peer, jchar verch, jchar horch) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) box(win, verch, horch);
}

jint pdcurses4j_wmove(JNIEnv *env, jobject that, jlong peer, jint y, jint x) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) wmove(win, y, x);
}

jint pdcurses4j_wattron(JNIEnv *env, jobject that, jlong peer, jint attrs) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) wattron(win, attrs);
}

jint pdcurses4j_wattroff(JNIEnv *env, jobject that, jlong peer, jint attrs) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) wattroff(win, attrs);
}

jint pdcurses4j_wattrset(JNIEnv *env, jobject that, jlong peer, jint attrs) {
 WINDOW* win = *(WINDOW **) &peer;
 return (jint) wattrset(win, attrs);
}

jint pdcurses4j_can_change_color(JNIEnv *env, jobject that) {
 return (jint) can_change_color();
}

jint pdcurses4j_init_color(JNIEnv *env, jobject that, jshort color, jshort red, jshort green, jshort blue) {
 return init_color(color, red, green, blue);
}

jint pdcurses4j_beep(JNIEnv *env, jobject that) {
 return beep();
}

jint pdcurses4j_flash(JNIEnv *env, jobject that) {
 return flash();
}

jint pdcurses4j_has_colors(JNIEnv *env, jobject that) {
 return (jint) has_colors();
}

jint pdcurses4j_colors(JNIEnv *env, jobject that) {
 return (jint) COLORS;
}

jint pdcurses4j_color_pairs(JNIEnv *env, jobject that) {
 return (jint) COLOR_PAIRS;
}

jint pdcurses4j_color_pair(JNIEnv *env, jobject that, jint n) {
 return (jint) COLOR_PAIR(n);
}

jint pdcurses4j_pair_number(JNIEnv *env, jobject that, jint n) {
 return (jint) PAIR_NUMBER(n);
}

jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_8) != JNI_OK) {
        return -1;
    }
    jvm = vm;
    jclass klass = (*env)->FindClass(env, "io/webfolder/pdcurses4j/PDCWindow");
    JNINativeMethod methods[] = {
        { "pdcurses4j_initscr", "()J", (void*) pdcurses4j_initscr },
        { "pdcurses4j_start_color", "()I", (void*) pdcurses4j_start_color },
        { "pdcurses4j_init_pair", "(SSS)I", (void*) pdcurses4j_init_pair },
        { "pdcurses4j_wattr_on", "(JI)I", (void*) pdcurses4j_wattr_on },
        { "pdcurses4j_wprintw", "(JLjava/lang/String;)I", (void*) pdcurses4j_wprintw },
        { "pdcurses4j_wrefresh", "(J)I", (void*) pdcurses4j_wrefresh },
        { "pdcurses4j_endwin", "()I", (void*) pdcurses4j_endwin },
        { "pdcurses4j_waddch", "(JC)I", (void*) pdcurses4j_waddch },
        { "pdcurses4j_wgetch", "(J)I", (void*) pdcurses4j_wgetch },
        { "pdcurses4j_waddstr", "(JLjava/lang/String;)I", (void*) pdcurses4j_waddstr },
        { "pdcurses4j_mvwaddstr", "(JIILjava/lang/String;)I", (void*) pdcurses4j_mvwaddstr },
        { "pdcurses4j_noecho", "()I", (void*) pdcurses4j_noecho },
        { "pdcurses4j_nodelay", "(JI)I", (void*) pdcurses4j_nodelay },
        { "pdcurses4j_napms", "(I)I", (void*) pdcurses4j_napms },
        { "pdcurses4j_mvwinsch", "(JIIC)I", (void*) pdcurses4j_mvwinsch },
        { "pdcurses4j_mvwdelch", "(JII)I", (void*) pdcurses4j_mvwdelch },
        { "pdcurses4j_wgetnstr", "(JI)Ljava/lang/String;", (void*) pdcurses4j_wgetnstr },
        { "pdcurses4j_unctrl", "(I)Ljava/lang/String;", (void*) pdcurses4j_unctrl },
        { "pdcurses4j_getmaxx", "(J)I", (void*) pdcurses4j_getmaxx },
        { "pdcurses4j_getmaxy", "(J)I", (void*) pdcurses4j_getmaxy },
        { "pdcurses4j_wclear", "(J)I", (void*) pdcurses4j_wclear },
        { "pdcurses4j_typeahead", "(I)I", (void*) pdcurses4j_typeahead },
        { "pdcurses4j_def_shell_mode", "()I", (void*) pdcurses4j_def_shell_mode },
        { "pdcurses4j_newwin", "(IIII)J", (void*) pdcurses4j_newwin },
        { "pdcurses4j_getpary", "(J)I", (void*) pdcurses4j_getpary },
        { "pdcurses4j_getparx", "(J)I", (void*) pdcurses4j_getparx },
        { "pdcurses4j_wbkgd", "(JJ)I", (void*) pdcurses4j_wbkgd },
        { "pdcurses4j_subwin", "(JIIII)J", (void*) pdcurses4j_subwin },
        { "pdcurses4j_touchwin", "(J)I", (void*) pdcurses4j_touchwin },
        { "pdcurses4j_derwin", "(JIIII)J", (void*) pdcurses4j_derwin },
        { "pdcurses4j_scrollok", "(JI)I", (void*) pdcurses4j_scrollok },
        { "pdcurses4j_box", "(JCC)I", (void*) pdcurses4j_box },
        { "pdcurses4j_wmove", "(JII)I", (void*) pdcurses4j_wmove },
        { "pdcurses4j_wattron", "(JI)I", (void*) pdcurses4j_wattron },
        { "pdcurses4j_wattroff", "(JI)I", (void*) pdcurses4j_wattroff },
        { "pdcurses4j_wattrset", "(JI)I", (void*) pdcurses4j_wattrset },
        { "pdcurses4j_can_change_color", "()I", (void*) pdcurses4j_can_change_color },
        { "pdcurses4j_init_color", "(SSSS)I", (void*) pdcurses4j_init_color },
        { "pdcurses4j_beep", "()I", (void*) pdcurses4j_beep },
        { "pdcurses4j_flash", "()I", (void*) pdcurses4j_flash },
        { "pdcurses4j_has_colors", "()I", (void*) pdcurses4j_has_colors },
        { "pdcurses4j_colors", "()I", (void*) pdcurses4j_colors },
        { "pdcurses4j_color_pairs", "()I", (void*) pdcurses4j_color_pairs },
        { "pdcurses4j_color_pair", "(I)I", (void*) pdcurses4j_color_pair },
        { "pdcurses4j_pair_number", "(I)I", (void*) pdcurses4j_pair_number }
    };

    (*env)->RegisterNatives(env, klass, methods, sizeof(methods) / sizeof(methods[0]));
    return JNI_VERSION_1_8;
}
