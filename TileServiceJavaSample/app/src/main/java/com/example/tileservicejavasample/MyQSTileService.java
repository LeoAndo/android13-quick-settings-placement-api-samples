package com.example.tileservicejavasample;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;

public class MyQSTileService extends TileService {
    public static final String TAG = "MyQSTileService";

    @Override
    public void onClick() {
        super.onClick();
        var tile = getQsTile(); // get Instance.
        switch (tile.getState()) {
            case Tile.STATE_ACTIVE:
                tile.setState(Tile.STATE_INACTIVE);
                break;
            case Tile.STATE_INACTIVE:
                tile.setState(Tile.STATE_ACTIVE);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tile);
        }
        Log.d(TAG, "onClick: tile.state: " + tile.getState());
        tile.updateTile();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        Log.d(TAG, "onTileAdded: Called when the user adds this tile to Quick Settings.");
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
        Log.d(TAG, "onTileRemoved: Called when the user removes this tile from Quick Settings.");
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        Log.d(TAG, "onStartListening: Called when this tile moves into a listening state.");
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
        Log.d(TAG, "onStopListening: Called when this tile moves out of the listening state.");
    }
}
