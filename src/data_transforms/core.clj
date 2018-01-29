(ns data-transforms.core
  (:gen-class)
  (:require [data-transforms.ingest-csv]
            [clojure.pprint :as pp]))


(defn -main [task filename]
  (case task
    "ingest-csv" (pp/pprint (data-transforms.ingest-csv/-main filename))))
