package edu.neu.ccs.cs5004.problem1;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class represents a media library.
 */
public class MediaLibrary {

  private Map<String, AbstractMedia> indexByAlias;
  private Map<Name, List<String>> mediasByDirector;
  private Map<String, Integer> mediaStream;

  /**
   * Create the library without stored information.
   */
  public MediaLibrary() {
    this.indexByAlias = new HashMap<>();
    this.mediasByDirector = new HashMap<>();
    this.mediaStream = new HashMap<>();
  }

  /**
   * Create the library with existed information.
   *
   * @param indexByAlias the map mapping the alias with the media
   * @param mediasByDirector the map mapping the director with the alias
   * @param mediaStream the map mapping the alias with the times of stream request
   */
  public MediaLibrary(Map<String, AbstractMedia> indexByAlias,
      Map<Name, List<String>> mediasByDirector, Map<String, Integer> mediaStream) {
    this.mediaStream = mediaStream;
    this.indexByAlias = indexByAlias;
    this.mediasByDirector = mediasByDirector;
  }

  /**
   * Get the map mapping the alias with the media.
   *
   * @return the map
   */
  public Map<String, AbstractMedia> getIndexByAlias() {
    return indexByAlias;
  }

  /**
   * Get the map mapping the director with the alias.
   *
   * @return the map
   */
  public Map<String, Integer> getMediaStream() {
    return mediaStream;
  }

  /**
   * Get the map mapping the alias with the times of stream request.
   *
   * @return the map
   */
  public Map<Name, List<String>> getMediasByDirector() {
    return mediasByDirector;
  }

  /**
   * Add a media to the library and update the relevant map.
   *
   * @param newMedia the new media
   * @return true if the media is successfully added to the library, vice versa.
   */
  public boolean addMedia(AbstractMedia newMedia) {
    try {
      addMediaHelper(newMedia);
      return true;
    } catch (AliasAlreadyExistException e) {
      return false;
    }
  }

  /**
   * The helper method to add the media.
   *
   * @param newMedia the new media
   * @throws AliasAlreadyExistException when the alias is already used
   */
  private void addMediaHelper(AbstractMedia newMedia) throws AliasAlreadyExistException {
    if (indexByAlias.containsKey(newMedia.getAlias())) {
      throw new AliasAlreadyExistException();
    } else {
      this.indexByAlias.put(newMedia.getAlias(), newMedia);
      for (Name director : newMedia.getDirectors()) {
        if (!mediasByDirector.containsKey(director)) {
          mediasByDirector.put(director, new LinkedList<>());
        }
        mediasByDirector.get(director).add(newMedia.getAlias());
      }
    }
  }

  /**
   * Get the medias made by the director, sorted by the release year.
   *
   * @param director the director
   * @return the list of medias sorted by the release year
   */
  public List<AbstractMedia> getMediaByDirector(Name director) {
    List<String> listOfAlias = mediasByDirector.get(director);
    List<AbstractMedia> listOfMovies = new LinkedList<>();
    for (String alias : listOfAlias) {
      listOfMovies.add(indexByAlias.get(alias));
    }
    Collections.sort(listOfMovies, (movie1, movie2) -> movie2.getYear() - movie1.getYear());
    return listOfMovies;
  }

  /**
   * Increase the number of times the media was streamed.
   *
   * @param alias the alias
   * @throws AliasNotExistException when the alias does not exist
   */
  public void requestStreaming(String alias) throws AliasNotExistException {
    if (indexByAlias.containsKey(alias)) {
      mediaStream.put(alias, mediaStream.getOrDefault(alias, 0) + 1);
    } else {
      throw new AliasNotExistException();
    }
  }

  /**
   * Get the number of streaming request given an alias.
   *
   * @param alias the alias
   * @return the number of streaming request
   */
  public int getStream(String alias) {
    if (mediaStream.containsKey(alias)) {
      return mediaStream.get(alias);
    } else {
      return 0;
    }
  }

  /**
   * Get the most streamed media.
   *
   * @return the most streamed media
   */
  public AbstractMedia getMostStreamedMedia() {
    Set<Entry<String, Integer>> aliasStreamingPair = mediaStream.entrySet();
    List<Entry<String, Integer>> aliasStreamList = new LinkedList<>();
    for (Entry<String, Integer> entry : aliasStreamingPair) {
      aliasStreamList.add(entry);
    }
    Collections.sort(aliasStreamList, (movie1, movie2) -> movie2.getValue() - movie1.getValue());
    return aliasStreamList.size() > 0
        ? indexByAlias.get(aliasStreamList.get(0).getKey()) : null;
  }

  /**
   * Return a string representation of this media library.
   *
   * @return a string representation of this media library
   */
  @Override
  public String toString() {
    return "This is a media library.";
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared
   * @return true if the two objects are the same, vice versa
   */
  @Override
  public boolean equals(Object obj) {
    if (super.equals(obj)) {
      return true;
    } else if (obj == null) {
      return false;
    } else {
      return this.getClass() == obj.getClass();
    }
  }

  /**
   * Return the hash code of this object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

