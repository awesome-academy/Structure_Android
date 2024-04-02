package com.sun.android.data.source.local.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sun.android.data.model.Movie;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movie> __insertionAdapterOfMovie;

  private final EntityDeletionOrUpdateAdapter<Movie> __deletionAdapterOfMovie;

  private final EntityDeletionOrUpdateAdapter<Movie> __updateAdapterOfMovie;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movies` (`id`,`backDropImage`,`overView`,`vote`,`voteCount`,`title`,`urlImage`,`originalTitle`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
        if (value.getBackDropImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBackDropImage());
        }
        if (value.getOverView() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOverView());
        }
        stmt.bindDouble(4, value.getVote());
        stmt.bindLong(5, value.getVoteCount());
        if (value.getTitle() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTitle());
        }
        if (value.getUrlImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUrlImage());
        }
        if (value.getOriginalTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOriginalTitle());
        }
      }
    };
    this.__deletionAdapterOfMovie = new EntityDeletionOrUpdateAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `movies` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfMovie = new EntityDeletionOrUpdateAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `movies` SET `id` = ?,`backDropImage` = ?,`overView` = ?,`vote` = ?,`voteCount` = ?,`title` = ?,`urlImage` = ?,`originalTitle` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
        if (value.getBackDropImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBackDropImage());
        }
        if (value.getOverView() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOverView());
        }
        stmt.bindDouble(4, value.getVote());
        stmt.bindLong(5, value.getVoteCount());
        if (value.getTitle() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTitle());
        }
        if (value.getUrlImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUrlImage());
        }
        if (value.getOriginalTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOriginalTitle());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public Object insert(final List<Movie> movies, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMovie.insert(movies);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Movie movie, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMovie.handle(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Movie movie, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMovie.handle(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getMovie(final int id, final Continuation<? super Movie> continuation) {
    final String _sql = "SELECT * from movies WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Movie>() {
      @Override
      public Movie call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBackDropImage = CursorUtil.getColumnIndexOrThrow(_cursor, "backDropImage");
          final int _cursorIndexOfOverView = CursorUtil.getColumnIndexOrThrow(_cursor, "overView");
          final int _cursorIndexOfVote = CursorUtil.getColumnIndexOrThrow(_cursor, "vote");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "voteCount");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrlImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlImage");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "originalTitle");
          final Movie _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpBackDropImage;
            if (_cursor.isNull(_cursorIndexOfBackDropImage)) {
              _tmpBackDropImage = null;
            } else {
              _tmpBackDropImage = _cursor.getString(_cursorIndexOfBackDropImage);
            }
            final String _tmpOverView;
            if (_cursor.isNull(_cursorIndexOfOverView)) {
              _tmpOverView = null;
            } else {
              _tmpOverView = _cursor.getString(_cursorIndexOfOverView);
            }
            final double _tmpVote;
            _tmpVote = _cursor.getDouble(_cursorIndexOfVote);
            final int _tmpVoteCount;
            _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUrlImage;
            if (_cursor.isNull(_cursorIndexOfUrlImage)) {
              _tmpUrlImage = null;
            } else {
              _tmpUrlImage = _cursor.getString(_cursorIndexOfUrlImage);
            }
            final String _tmpOriginalTitle;
            if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
              _tmpOriginalTitle = null;
            } else {
              _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            }
            _result = new Movie(_tmpId,_tmpBackDropImage,_tmpOverView,_tmpVote,_tmpVoteCount,_tmpTitle,_tmpUrlImage,_tmpOriginalTitle);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllMovies(final Continuation<? super List<Movie>> continuation) {
    final String _sql = "SELECT * from movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Movie>>() {
      @Override
      public List<Movie> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBackDropImage = CursorUtil.getColumnIndexOrThrow(_cursor, "backDropImage");
          final int _cursorIndexOfOverView = CursorUtil.getColumnIndexOrThrow(_cursor, "overView");
          final int _cursorIndexOfVote = CursorUtil.getColumnIndexOrThrow(_cursor, "vote");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "voteCount");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrlImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlImage");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "originalTitle");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpBackDropImage;
            if (_cursor.isNull(_cursorIndexOfBackDropImage)) {
              _tmpBackDropImage = null;
            } else {
              _tmpBackDropImage = _cursor.getString(_cursorIndexOfBackDropImage);
            }
            final String _tmpOverView;
            if (_cursor.isNull(_cursorIndexOfOverView)) {
              _tmpOverView = null;
            } else {
              _tmpOverView = _cursor.getString(_cursorIndexOfOverView);
            }
            final double _tmpVote;
            _tmpVote = _cursor.getDouble(_cursorIndexOfVote);
            final int _tmpVoteCount;
            _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUrlImage;
            if (_cursor.isNull(_cursorIndexOfUrlImage)) {
              _tmpUrlImage = null;
            } else {
              _tmpUrlImage = _cursor.getString(_cursorIndexOfUrlImage);
            }
            final String _tmpOriginalTitle;
            if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
              _tmpOriginalTitle = null;
            } else {
              _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            }
            _item = new Movie(_tmpId,_tmpBackDropImage,_tmpOverView,_tmpVote,_tmpVoteCount,_tmpTitle,_tmpUrlImage,_tmpOriginalTitle);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
