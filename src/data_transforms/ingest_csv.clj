(ns data-transforms.ingest-csv
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(defn ingest-from [filename]
  (csv/read-csv (slurp (io/resource filename))))

; (defn read-column [filename column-index]
;   (let [data (ingest-from filename)]
;     (map #(nth % column-index) data)))

(defn csv-data->maps [filename]
  (let [data (ingest-from filename)]
    (map zipmap
      (->> (first data)
           (map keyword)
           repeat)
      (rest data))))

(defn -main [filename]
  (csv-data->maps filename))