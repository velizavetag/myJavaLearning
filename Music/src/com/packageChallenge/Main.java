package com.packageChallenge;

import com.packageChallenge.model.Artist;
import com.packageChallenge.model.Datasource;
import com.packageChallenge.model.SongArtist;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Can't open datasource");
            return;
        }

//        ===================quering all artists=============================================================

//        List<Artist> artists = datasource.queryArtist(2);
//        if(artists == null){
//            System.out.println("No artists!");
//        }
//
//        for(Artist artist : artists){
//            System.out.println("ID = " + artist.getId() + ".  Name = " + artist.getName());
//        }
//        =================quering albums for artists=========================================================
//
//        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC);
//
//        for(String album : albumsForArtist){
//            System.out.println(album);
//
//        }

//        List<SongArtist> songArtists = datasource.queryArtistForSong("Heartless", Datasource.ORDER_BY_ASC);
//        if(songArtists == null){
//            System.out.println("Couldn't find artist for the song");
//            return;
//        }
//
//        for(SongArtist artist : songArtists){
//            System.out.println("\t Artist name = " + artist.getArtistName() +
//                                "\t Album name = " + artist.getAlbumName() +
//                                "\tTrack = " + artist.getTrack());
//        }
//
//        datasource.querySongsMetaData();
//
//        int count = datasource.getCount(Datasource.TABLE_SONGS);
//        System.out.println("Number of songs is : " + count);

//        datasource.createViewForSongArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title : ");
        String title = scanner.nextLine();


        List<SongArtist> songArtist = datasource.querySongInfoWiew(title);
        if(songArtist.isEmpty()){
            System.out.println("Couldn't find the artist for the song");

        }

        for(SongArtist artist : songArtist){
            System.out.println(" FROM VIEW - \tArtist name = " + artist.getArtistName() +
                                "\tAlbum = " + artist.getAlbumName() + "\t\tTrack =" + artist.getTrack());;
        }

        datasource.insertSong("Touch of grey", "Greatful Dead", "In the dark", 1);

        datasource.close();
        
    }




}
