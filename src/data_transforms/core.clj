(ns data-transforms.core
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [clojure.pprint :as pp]))

(defn ingest-from [filename]
  (csv/read-csv (slurp (io/resource filename))))

(defn read-column [filename column-index]
  (let [data (ingest-from filename)]
    (map #(nth % column-index) data)))

(defn csv-data->maps [filename]
  (let [data (ingest-from filename)]
    ; (println (first data))))
    (map zipmap
      (->> (first data)
           (map keyword)
           repeat)
      (rest data))))

(defn transform [filename]
  (pp/pprint (csv-data->maps filename)))

(defn -main [filename] (transform filename))
